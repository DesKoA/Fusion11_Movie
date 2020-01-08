package db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import data.Theaters;
import db.util.OracleDBUtil;

public class TheatersDBManager {
	public Connection con;
	
	public TheatersDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public TheatersDBManager(Connection con) {
		this.con = con;
	}

	public ArrayList<Theaters> selectOneMovie(String movTitle) {
		if (con != null) {
			String sql = "select * from movie_theaters where movie_title = " + "'" + movTitle + "'";
					// "select m.*, to_char(m.movie_date, 'YYYY-fmMM-DD') as to_date from movie_theaters m where movie_title = " + "'" + movTitle + "'";
			// "select screen_no, screen_name, movie_title, movie_poster, to_char(movie_date, 'YYYY. fmMM. DD') from dual, movie_start, movie_end"+ " from movie_theaters where movie_title = " + "'" + movTitle + "'";
			// String sql = "select * from movie_theaters where movie_title = " + "'" + movTitle + "'";
			// String toCharSql = "select to_char(movie_date, 'YYYY-fmMM-DD') from movie_theaters";
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<Theaters> thList = new ArrayList<>();
				while (rs.next()) {
					int id = rs.getInt(1);
					String scName = rs.getString(2);
					String movieTitle = rs.getString(3);
					String moviePoster = rs.getString(4);
					// String dateStr = String.valueOf(rs.getDate(5));
					// SimpleDateFormat sf = new SimpleDateFormat("YYYY-M-d");
					Date movieDate = rs.getDate(5);
					// Date movieDate = sf.parse(dateStr);
					// System.out.println((sf.format(sf.parse(dateStr))));
					String start = rs.getString(6);
					String end = rs.getString(7);
					Theaters th = new Theaters(id, scName, movieTitle, moviePoster, movieDate, start, end);
					thList.add(th);
				}
				return thList;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	
	public String[] selectOneMovieScreenByDate(String movTitle) {
		if (con != null) {
			String sql = "select screen_name from movie_theaters where movie_title=" + "'" + movTitle + "'" + "GROUP BY screen_name, movie_title"; 
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				int count = 0;
				ArrayList<String> list = new ArrayList<>();
				while(rs.next()) {
					count++;
					list.add(rs.getString(1));
				}
				String[] thList = new String[count];
				for (int i = 0; i < thList.length; i++) {
					thList[i] = list.get(i);
				}
				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}
	
	public LinkedHashMap<String, ArrayList<String>> selectOneMovieStartByName(String movTitle, Date movDate) {
		if (con != null) {
			SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
			String dateStr = sf.format(movDate);
			String sql = "select movie_start, screen_name from movie_theaters where movie_title=" + "'" + movTitle + "'"
					+ " and TO_CHAR(movie_date, 'YYYYMMDD')=" + "'" + dateStr + "'" + " order by movie_start asc";
			// 각각 관의 대해서 추가.
			ArrayList<String> thList1 = new ArrayList<>();
			ArrayList<String> thList2 = new ArrayList<>();
			ArrayList<String> thList3 = new ArrayList<>();
			ArrayList<String> thList4 = new ArrayList<>();
			ArrayList<String> thList5 = new ArrayList<>();
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				LinkedHashMap<String, ArrayList<String>> thList = new LinkedHashMap<>();
				while (rs.next()) {
					String mvStart = rs.getString(1);
					String scName = rs.getString(2);
					switch (scName) {
					case "1관":
						thList1.add(mvStart);
						break;
					case "2관":
						thList2.add(mvStart);
						break;
					case "3관":
						thList3.add(mvStart);
						break;
					case "4관":
						thList4.add(mvStart);
						break;
					case "5관":
						thList5.add(mvStart);
						break;
					default:
						break;
					}
				}
				if (thList1.size() != 0) thList.put("1관", thList1);
				if (thList2.size() != 0) thList.put("2관", thList2);
				if (thList3.size() != 0) thList.put("3관", thList3);
				if (thList4.size() != 0) thList.put("4관", thList4);
				if (thList5.size() != 0) thList.put("5관", thList5);

				return thList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 오류");
		}
		return null;
	}
	
	public static void main(String[] args) {
		OracleDBUtil.connectDB();
		TheatersDBManager thMgr = new TheatersDBManager();
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 0, 10);
		Date tDate = cal.getTime();
		LinkedHashMap<?, ?> hash = thMgr.selectOneMovieStartByName("백두산", tDate);
		System.out.println(hash);
		OracleDBUtil.closeDB();
	}
	
}
