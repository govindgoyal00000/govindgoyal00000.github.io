package com.govind.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Scanner sc=new Scanner(System.in);
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			1.2 Connect to Database
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
//			2. Query
			preparedStatement=connection.prepareStatement("INSERT INTO ELEMENT VALUES(?,?,?)");
			
			System.out.println("Enter the Element Atomic number: ");
			int aWgt=sc.nextInt();
			System.out.println("Enter the Element Name: ");
			String name=sc.next();
			System.out.println("Enter the Element Chemical Symbol: ");
			String symbol=sc.next();
			
			preparedStatement.setInt(1, aWgt);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, symbol);
			
			int rows= preparedStatement.executeUpdate();

//			3.Process Result
			if(rows>0) {
				System.out.println("Record added!");
			}
			else {
				System.out.println("Record addition failed.");
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