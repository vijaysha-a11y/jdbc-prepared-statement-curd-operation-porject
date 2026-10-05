package com.techmahindra.jdbc.prepared.statement.crud.operation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.techmahindra.jdbc.prepared.statement.crud.connection.JdbcConnection;
import com.techmahindra.jdbc.prepared.statement.crud.operation.dto.Product;

public class ProductDao {

	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet set = null;
	final private String INSERT_PRODUCT_QUERY = "insert into product(id, name, price, mfd, color) values(?,?,?,?,?)";
	final private String DISPLAY_ALL_PRODUCT = "select * from product";
	final private String DISPLAY_PRODUCT_BY_ID = "select * from product where id=?";
	final private String DELETE_PRODUCT_BY_ID_QUERY = "delete from product where id=?";
	final private String UPDATE_PRODUCT_BY_ID_QUERY = "update product set name=?, price=?, mfd=?,color=? where id=?";

	// order by price desc
	public int saveProdutctDao(Product product) {
		try {

			connection = JdbcConnection.getMyConnection();
			// step-3 create satatement by using preparedstatemtn
			ps = connection.prepareStatement(INSERT_PRODUCT_QUERY);

			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setDate(4, product.getMfd());
			ps.setString(5, product.getColor());
			int a = ps.executeUpdate();
			String msg = a != 0 ? "Registerd Successfully" : "Somethink went wrong";
			System.out.println(msg);
			return a;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Product> getAllProductDao() {
		try {
			connection = JdbcConnection.getMyConnection();
			ps = connection.prepareStatement(DISPLAY_ALL_PRODUCT);
			set = ps.executeQuery(DISPLAY_ALL_PRODUCT);

			List<Product> products = new ArrayList<>();

			while (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				double price = set.getDouble("price");
				Date mfd = set.getDate("mfd");
				String color = set.getString("color");

				Product product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setMfd(mfd);
				product.setColor(color);

				products.add(product);
			}
			return products;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public List<Product> sortAllProductInDESCByPrice() {
//		List<Product> products = getAllProductDao();
//		Stream<Product> stream = products.stream();
//		return stream.sorted.(Comparator.comparingDouble(p->p.getPrice())).toList();

		return getAllProductDao().stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
	}

	public boolean deleteProductById(int productId) {
		try {
			connection = JdbcConnection.getMyConnection();
			ps = connection.prepareStatement(DELETE_PRODUCT_BY_ID_QUERY);
			ps.setInt(1, productId);

			int a = ps.executeUpdate();

			return a != 0 ? true : false;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int saveMultipleProductDao(List<Product> products) {
		try {
			connection = JdbcConnection.getMyConnection();
			ps = connection.prepareStatement(INSERT_PRODUCT_QUERY);
			// set autocommit as false
			connection.setAutoCommit(false);

			for (Product product : products) {
				ps.setInt(1, product.getId());
				ps.setString(2, product.getName());
				ps.setDouble(3, product.getPrice());
				ps.setDate(4, product.getMfd());
				ps.setString(5, product.getColor());

				ps.addBatch();
			}
			int a[] = ps.executeBatch();
			connection.commit();
			return a.length;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		} finally {
			if (ps != null) {
				try {
					ps.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int deleteMultipleProductInBatchByIdDao(List<Integer> productsId) {
		try {
			connection = JdbcConnection.getMyConnection();
			ps = connection.prepareStatement(DELETE_PRODUCT_BY_ID_QUERY);
			// set auto commit mode as false
			connection.setAutoCommit(false);
			for (Integer productId : productsId) {
				ps.setInt(1, productId);
				ps.addBatch();
			}
			int a[] = ps.executeBatch();
			connection.commit();
			return a.length;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int updateProductDetails(Product product) {
		try (Connection connection = JdbcConnection.getMyConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_BY_ID_QUERY);) {

			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setDate(3, product.getMfd());
			ps.setString(4, product.getColor());
			ps.setInt(5, product.getId());
			System.out.println(product);

			System.out.println(ps);
			return ps.executeUpdate() != 0 ? 1 : 0;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

//	in this code have some error
	public Product getProductByIdDao(int productId) {
		try {
			connection = JdbcConnection.getMyConnection();
			ps = connection.prepareStatement(DISPLAY_PRODUCT_BY_ID);

			ps.setInt(1, productId);
			set = ps.executeQuery();

			if (set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				double price = set.getDouble("price");
				Date mfd = set.getDate("mfd");
				String color = set.getString("color");

				Product product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setColor(color);
				product.setMfd(mfd);

				return product;
			}
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (set != null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(ps !=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
