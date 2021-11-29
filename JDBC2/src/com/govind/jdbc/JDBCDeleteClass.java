package com.govind.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDeleteClass {

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
			preparedStatement=connection.prepareStatement("DELETE FROM ELEMENT WHERE CHEMICAL_SYMBOL=?");
			
			System.out.println("Enter the symbol of the element: ");
			String symbol=sc.next();
			preparedStatement.setString(1, symbol );


			int rows= preparedStatement.executeUpdate();



//			3.Process Result
			if(rows>0) {
				System.out.println("Record deleted!");
			}
			else {
				System.out.println("Record deletion failed.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {

				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
