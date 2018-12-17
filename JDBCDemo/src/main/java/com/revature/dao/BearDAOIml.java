package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.util.ConnectionUtil;

public class BearDAOIml implements BearDAO {

	private static final String filename = "connection.properties";

	public BearDAOIml() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bear> getBears() {
		List<Bear> bl = new ArrayList<Bear>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies bear, cave, and beartype into a resultset
			// map the resultset's entries onto a list of bear objects
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.WEIGHT, B.BEARTHDAY, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME\r\n" + 
					"FROM BEAR B\r\n" + 
					"INNER JOIN BEAR_TYPE BT\r\n" + 
					"ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID\r\n" + 
					"INNER JOIN CAVE C\r\n" + 
					"ON B.CAVE_ID = C.CAVE_ID\r\n" + 
					"ORDER BY B.BEAR_ID;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_ID");
				double weight = rs.getDouble("WEIGHT");
				LocalDate bearthday = rs.getDate("BEARTHDAY").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				bl.add(new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName), weight, bearthday));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;
	}
	
	@Override
	public Bear getBearById(int id) {
		List<Bear> bl = new ArrayList<Bear>();
		Bear b = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies bear, cave, and beartype into a resultset
			// map the resultset's entry
			
			String sql = "SELECT B.BEAR_ID, B.BEAR_NAME, B.WEIGHT, B.BEARTHDAY, C.CAVE_ID, C.CAVE_NAME, C.MAX_BEARS, BT.BEAR_TYPE_ID, BT.BEAR_TYPE_NAME\r\n" + 
					"FROM BEAR B\r\n" + 
					"INNER JOIN BEAR_TYPE BT\r\n" + 
					"ON B.BEAR_TYPE_ID = BT.BEAR_TYPE_ID\r\n" + 
					"INNER JOIN CAVE C\r\n" + 
					"WHERE B.BEAR_ID = ?\r\n" +
					"ON B.CAVE_ID = C.CAVE_ID\r\n" + 
					"ORDER BY B.BEAR_ID;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int bearId = rs.getInt("BEAR_ID");
				String bearName = rs.getString("BEAR_ID");
				double weight = rs.getDouble("WEIGHT");
				LocalDate bearthday = rs.getDate("BEARTHDAY").toLocalDate();
				int caveId = rs.getInt("CAVE_ID");
				String caveName = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				int bearTypeId = rs.getInt("BEAR_TYPE_ID");
				String bearTypeName = rs.getString("BEAR_TYPE_NAME");
				b = new Bear(bearId, bearName, new Cave(caveId, caveName, maxBears), new BearType(bearTypeId, bearTypeName), weight, bearthday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

}
