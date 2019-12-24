package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.MovieInfo;

public class MovieDBManager {
	public static final String USER = "java";
	public static final String PW = "1234";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";

	public static Connection con;

	public static void connectDB() {
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeDB() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<MovieInfo> movie_selectAll() {
		if (con != null) {
			String sql = "select * from movie_info";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<MovieInfo> mvList = new ArrayList<>();
				while (rs.next()) {
					MovieInfo tp = new MovieInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getInt(11));
					System.out.println(tp);
					mvList.add(tp);
				}
				return mvList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return null;
	}

	public static void main(String[] args) {
		connectDB();
		movie_selectAll();
		closeDB();
	}
}
