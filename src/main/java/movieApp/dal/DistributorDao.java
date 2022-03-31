package movieApp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movieApp.model.Distributor;

public class DistributorDao {
protected ConnectionManager connectionManager;
	
	private static DistributorDao instance = null;
	protected DistributorDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static DistributorDao getInstance() {
		if(instance == null) {
			instance = new DistributorDao();
		}
		return instance;
	}
	
	public Distributor create(Distributor distributor) throws SQLException{
		String insertDistributor = "INSERT INTO Distrobutor(DistributorName,MoviesQuantity) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertDistributor);
			
			insertStmt.setString(1,distributor.getDistributorName());
			insertStmt.setInt(2, distributor.getMoviesQuantity());
			insertStmt.executeUpdate();
			
			return distributor;
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
	
	public Distributor getDistributorName(String DistributorName) throws SQLException {
		String selectRes = "SELECT DistributorName,MoviesQuantity FROM Distributor WHERE DistributorName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setString(1, DistributorName);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String dn = results.getString("DistributorName");
				int mq = results.getInt("MoviesQuantity");
				Distributor d = new Distributor(dn,mq);
				
				return d;
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
	
	public Distributor getMoviesQuantity(int MoviesQuantity) throws SQLException {
		String selectRes = "SELECT DistributorName,MoviesQuantity FROM Distributor WHERE MoviesQuantity=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, MoviesQuantity);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String dn = results.getString("DistributorName");
				int mq = results.getInt("MoviesQuantity");
				Distributor d = new Distributor(dn,mq);
				
				return d;
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
		
	public Distributor delete(Distributor distributor) throws SQLException {
		String deleteUser = "DELETE FROM Distributor WHERE DistributorName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, distributor.getDistributorName());
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
	

}
