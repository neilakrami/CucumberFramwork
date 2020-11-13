package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	
	// JDBC:mysql://hostname:port/db name
                                //hostname   //port	  //db name
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";
	
	//@Test
	public void dbmetaMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMedtaData = conn.getMetaData(); //---> this methed going to return us something
		String driverName = dbMedtaData.getDriverName();
		String version = dbMedtaData.getDatabaseProductVersion();
		
		System.out.println(driverName);
		System.out.println(version);
	}
	@Test
	public void resultSetMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees where employee_id = 8392");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		System.out.println(columnCount);
		String columnName = rsMetaData.getColumnName(1);
		System.out.println(columnName);
		
		for(int i = 1; i<= columnCount; i++) {
			String columnNames = rsMetaData.getColumnName(i);
			System.out.println(columnNames);
		}
		
		
	}
}
