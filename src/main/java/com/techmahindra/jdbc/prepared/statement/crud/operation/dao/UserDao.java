package com.techmahindra.jdbc.prepared.statement.crud.operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techmahindra.jdbc.prepared.statement.crud.connection.JdbcConnection;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.User;

public class UserDao {
	private final String REGISTER_USER_QUERY = "insert into user(email,password) values(?,?)";
    private final String LOGIN_USER_QUERY="select email,password from user where email=? AND password=?";
	public int registerUserDao(User user) {
		try (
				Connection connection = JdbcConnection.getMyConnection();
				PreparedStatement ps = connection.prepareStatement(REGISTER_USER_QUERY);
				){
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			return ps.executeUpdate()!=0?1:0;
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public boolean loginUserDao(String email, String password) {
		try(
				Connection connection = JdbcConnection.getMyConnection();
				PreparedStatement ps = connection.prepareStatement(LOGIN_USER_QUERY);
		){
			ps.setString(1, email);
			ps.setString(2, password);
			
			if(ps.executeQuery().next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
