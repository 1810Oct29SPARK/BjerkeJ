package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOIml;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		//init();
		BearDAO bd = new BearDAOIml();
		List<Bear> bears = bd.getBears();
//		for(Bear b : bears) {
//			System.out.println(b);
//		}
		//get single bear
		System.out.println(bd.getBearById(1020));
	}
	
	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}