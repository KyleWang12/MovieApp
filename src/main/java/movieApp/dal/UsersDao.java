
package movieApp.dal;
import movieApp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
	protected ConnectionManager connectionManager;
	private static UsersDao instance = null;
	
	protected UsersDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UsersDao getInstance() {
		if(instance == null) {
			instance = new UsersDao();
		}
		return instance;
	}

	public Users create(Users user) throws SQLException {
		String insertUser = "INSERT INTO Users(UserName,Password,FirstName,LastName,Phone,Email) VALUES(?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, user.getUserName());
			insertStmt.setString(2, user.getPassword());
			insertStmt.setString(3, user.getFirstName());
			insertStmt.setString(4, user.getLastName());
			insertStmt.setString(5, user.getPhone());
			insertStmt.setString(6, user.getEmail());
		
			insertStmt.executeUpdate();
			resultKey = insertStmt.getGeneratedKeys();
			int userId = -1;
			if (resultKey.next()) {
				userId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			user.setUserId(userId);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}

	
	public Users delete(Users user) throws SQLException {
		String deleteUser = "DELETE FROM Users WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, user.getUserName());
			deleteStmt.executeUpdate();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}


	public Users getUserByUserId(Integer userId) throws SQLException {
		String selectUser = "SELECT UserId,UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE UserId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setInt(1, userId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultUserId = results.getInt("UserId");
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String phone = results.getString("Phone");
				String email = results.getString("Email");
				Users user = new Users(resultUserId,userName, password, firstName, lastName, phone, email);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	public Users getUserByUserName(String userName) throws SQLException {
		String selectUser = "SELECT UserId, UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE UserName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, userName);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int userId = results.getInt("UserId");
				String resultUserName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String phone = results.getString("Phone");
				String email = results.getString("Email");
				Users user = new Users(userId, resultUserName, password, firstName, lastName,  phone, email);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}

	public Users getUserByPhone(String phone) throws SQLException{
		String selectUser = "SELECT UserId,UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE Phone=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, phone);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int userId = results.getInt("UserId");
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String resultPhone = results.getString("Phone");
				String email = results.getString("Email");
				Users user = new Users(userId,userName, password, firstName, lastName,  resultPhone, email);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	
	public Users getUserByEmail(String email) throws SQLException{
		String selectUser = "SELECT UserId,UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE Email=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, email);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int userId = results.getInt("UserId");
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String phone = results.getString("Phone");
				String resultEmail = results.getString("Email");
				Users user = new Users(userId, userName, password, firstName, lastName,  phone, resultEmail);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
	public List<Users> getUsersByFirstName(String firstName) throws SQLException{
		List<Users> users = new ArrayList<Users>();
		String selectUser = "SELECT UserId,UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE FirstName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, firstName);
			results = selectStmt.executeQuery();
			while (results.next()) {
				int userId = results.getInt("UserId");
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				String resultFirstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String phone = results.getString("Phone");
				String resultEmail = results.getString("Email");
				Users user = new Users(userId, userName, password, resultFirstName, lastName,  phone, resultEmail);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return users;
	}
	
	public List<Users> getUsersByLastName(String LastName) throws SQLException{
		List<Users> users = new ArrayList<Users>();
		String selectUser = "SELECT UserId,UserName,Password,FirstName,LastName,Phone,Email FROM Users WHERE LastName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, LastName);
			results = selectStmt.executeQuery();
			while (results.next()) {
				int userId = results.getInt("UserId");
				String userName = results.getString("UserName");
				String password = results.getString("Password");
				String firstName = results.getString("FirstName");
				String resultLastName = results.getString("LastName");
				String phone = results.getString("Phone");
				String resultEmail = results.getString("Email");
				Users user = new Users(userId, userName, password, firstName, resultLastName,  phone, resultEmail);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return users;
	}
}
