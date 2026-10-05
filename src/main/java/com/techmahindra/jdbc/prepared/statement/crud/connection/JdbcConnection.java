package com.techmahindra.jdbc.prepared.statement.crud.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
			//step-1 load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step-2 
			String url="jdbc:mysql://localhost:3306/jdbc-m21";
			String username="root";
			String password="root";
			return DriverManager.getConnection(url, username, password);
	}
}
