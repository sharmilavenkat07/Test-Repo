package org.page.execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlTest {
public static void main(String[] args) {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "Hourglass@13");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}System.out.println("connected");
}
}
