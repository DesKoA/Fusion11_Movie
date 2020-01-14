package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Seat;
import db.util.OracleDBUtil;

public class SeatDBManager {
public Connection con;
	
	public SeatDBManager() {
		this.con = OracleDBUtil.con;
	}
	
	public SeatDBManager(Connection con) {
		this.con = con;
	}
	
	public boolean insertSeat(Seat seat) {
		if (con != null) {
			String sql = "insert into movie_seats values(seat_seq.nextval, ?, ?, ?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, seat.getScreenNo());
				pstmt.setString(2, String.valueOf(seat.getSeatRow()));
				pstmt.setInt(3, seat.getSeatCol());
				
				int r = pstmt.executeUpdate();
				if (r == 1) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			
		}
		return false;
	}
	
	public ArrayList<String> selectAllSeatsName(int scNo) {
		if (con != null) {
			String sql = "select * from movie_seats where screen_no = " + "'" + scNo + "'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				ArrayList<String> seatList = new ArrayList<>();
				while (rs.next()) {
					String seat = rs.getString("seat_row") + rs.getString("seat_col");
					seatList.add(seat);
				}
				return seatList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			
		}
		return null;
	}
}
