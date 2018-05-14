package com.ericsson.ewazhon.database;

import java.sql.*;
import com.ericsson.ewazhon.common.*;

public class ClientDatabaseHelp {

	public volatile  static ClientDatabaseHelp instance;
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	private String DatabaseDriver = "com.mysql.cj.jdbc.Driver";
	private String DatabaseConnStr = "jdbc:mysql://127.0.0.1:3306/excursionboats";
	private String Username = "root";
	private String Password = "ewazhon";

	public static ClientDatabaseHelp getInstance() throws Exception {
		
		if (instance == null)
		{
			synchronized(ClientDatabaseHelp.class) {
				if (instance == null)
				{
					instance = new ClientDatabaseHelp();
				}
			}
		}
		
		return instance;
	}

	private ClientDatabaseHelp() throws Exception {

		try {
			Class.forName(DatabaseDriver).newInstance(); // register the
			// database driven
		} catch (Exception ex) {
			String error = "register database driven failed:" + ex.getMessage();
			throw new AppException(error, ex.getCause());
		}

	}

	public int executeInsert(String sql) throws Exception{
		int num = 0;
		try {

			conn = DriverManager.getConnection(DatabaseConnStr,Username,Password);
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
			
		} catch (SQLException ex) {
			String error = "execute sql " + sql + ":" + ex.getMessage();
			throw new AppException(error, ex.getCause());
			
		}
		CloseDataBase();
		return num;
	}

	public ResultSet executeQuery(String sql) throws Exception{
		rs = null;
		try {
			conn = DriverManager.getConnection(DatabaseConnStr,Username,Password);
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			String error = "execute sql " + sql + ":" + ex.getMessage();
			throw new AppException(error, ex.getCause());
		}
		return rs;
	}

	public int executeDelete(String sql) throws Exception {
		int num = 0;
		try {
			conn = DriverManager.getConnection(DatabaseConnStr,Username,Password);
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException ex) {
			String error = "execute sql " + sql + ":" + ex.getMessage();
			throw new AppException(error, ex.getCause());
			
		}
		
		CloseDataBase();
		return num;
	}
	
	public int executeUpdate(String sql) throws Exception {
		int num = 0;
		try {
			conn = DriverManager.getConnection(DatabaseConnStr,Username,Password);
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException ex) {
			String error = "execute sql " + sql + ":" + ex.getMessage();
			throw new AppException(error, ex.getCause());
			
		}
		
		CloseDataBase();
		return num;
	}

	public void CloseDataBase() throws Exception {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				String error = "close Connection error: "  + ex.getMessage();
				throw new AppException(error, ex.getCause());
			}

		}
	}

}
