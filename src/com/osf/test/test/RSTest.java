package com.osf.test.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.osf.test.db.DBCon;

public class RSTest {
	public static void main(String[] args) {
		String sql = "select * from food";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Map<String, String>> colList = new ArrayList<>();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnLabel(i);
				colName = colName.toLowerCase();
				int idx = colName.indexOf("_");
				String fName = colName.substring(0, idx); // 0부터 idx까지
				String lName = colName.substring(idx + 1);
				// lName에 첫글자 짜르고 나머지 글자 붙이기
				lName = lName.substring(0, 1).toUpperCase() + lName.substring(1);

				Map<String, String> col = new HashMap<>();
				col.put(colName, fName + lName);
				colList.add(col);
			}
			System.out.println(colList);
			while (rs.next()) {
				Map<String, String> row = new HashMap<>();
				for (Map<String, String> col : colList) {
					Iterator<String> it = col.keySet().iterator();
					String key = it.next();
					String value = rs.getString(key);
					row.put(col.get(key), value);
				}
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}
}
