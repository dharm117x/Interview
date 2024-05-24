package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JavaJdbcTest {
	public static void main(String[] args) {

		getEmployee("101", "A");

	}

	private static void getEmployee(String id, String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from Employee where ");
		Map<String, Object> maps = new HashMap<>();
		if (id != null) {
			sql.append(" id = ?");
			maps.put("id", id);
		} else if (name != null) {
			sql.append(" name = ?");
			maps.put("name", name);
		}

		Connection con = null;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(maps.get("id")!= null) {
				pstmt.setString(0, (String)maps.get("id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
