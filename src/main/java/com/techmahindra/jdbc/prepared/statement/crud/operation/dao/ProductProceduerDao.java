package com.techmahindra.jdbc.prepared.statement.crud.operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techmahindra.jdbc.prepared.statement.crud.connection.JdbcConnection;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

public class ProductProceduerDao {
	Connection  connection =null;
	PreparedStatement cs = null;
	ResultSet set = null;
	public int saveProdutctDao(Product product) {
		try {
			connection = JdbcConnection.getMyConnection();
			//step-3 create satatement by using preparedstatemtn
			cs = connection.prepareCall("call insertProduct(?,?,?,?,?)");
			
			cs.setInt(1, product.getId());
			cs.setString(2, product.getName());
			cs.setDouble(3, product.getPrice());
			cs.setString(4, product.getColor());
			cs.setDate(5, product.getMfd());
			int a = cs.executeUpdate();
			String msg = a!=0?"Registerd Successfully":"Somethink went wrong";
			System.out.println(msg);
			return a;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			if(cs!=null) {
				try {
					cs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
