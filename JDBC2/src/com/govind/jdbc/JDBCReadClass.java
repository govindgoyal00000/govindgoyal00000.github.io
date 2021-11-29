package com.govind.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCReadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("SELECT * FROM ELEMENT");
			
			ResultSet resultSet= preparedStatement.executeQuery();

//			3.Process Result
			while(resultSet.next()) {
				int aWgt=resultSet.getInt("ATOMIC_WGT");
				String name=resultSet.getString("NAME");
				String symbol=resultSet.getString("CHEMICAL_SYMBOL");
				System.out.println(aWgt+"  "+name+"  "+symbol);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
//				4. Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
