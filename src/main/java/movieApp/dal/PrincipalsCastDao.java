package movieApp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import movie.model.PrincipalsCast;
import movie.model.Users;


public class PrincipalsCastDao{
	protected ConnectionManager connectionManager;
	private static PrincipalsCastDao instance = null;
	
	protected PrincipalsCastDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static PrincipalsCastDao getInstance() {
		if(instance == null) {
			instance = new PrincipalsCastDao();
		}
		return instance;
	}

	public PrincipalsCast create(PrincipalsCast principalsCast) throws SQLException {
		String insertPrincipalsCast = "INSERT INTO PrincipalsCast(Tconst, Nconst, Category, JobTitle) VALUES(?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertPrincipalsCast, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, principalsCast.getTconst());
			insertStmt.setString(2, principalsCast.getNconst());
			insertStmt.setString(3, principalsCast.getCategory());
			insertStmt.setString(4, principalsCast.getJobTitle());
		
			insertStmt.executeUpdate();
			resultKey = insertStmt.getGeneratedKeys();
			int principalsCastId = -1;
			if (resultKey.next()) {
				principalsCastId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			principalsCast.setPrincipalsCastId(principalsCastId);
			return principalsCast;
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

	
	public PrincipalsCast delete(PrincipalsCast principalsCast) throws SQLException {
		String deletePrincipalsCast = "DELETE FROM PrincipalsCast WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deletePrincipalsCast);
			deleteStmt.setString(1, principalsCast.getTconst());
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


	public PrincipalsCast getPrincipalsCastByTconst(String Tconst) throws SQLException  {
		String selectPrincipalsCast = "SELECT PrincipalsCastId,Tconst,Nconst,Category,JobTitle FROM PrincipalsCast WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrincipalsCast);
			selectStmt.setString(1, Tconst);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int principalsCastId = results.getInt("PrincipalsCastId");
				String resultTconst = results.getString("Tconst");
				String nconst = results.getString("Nconst");
				String category = results.getString("Category");
				String jobTitle = results.getString("JobTitle");
				PrincipalsCast principalsCast = new PrincipalsCast(principalsCastId, resultTconst, nconst,category,jobTitle);
				return principalsCast;
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
	
	public PrincipalsCast getPrincipalsCastByPrincipalsCastId(int PrincipalsCastId) throws SQLException{
		String selectPrincipalsCast = "SELECT PrincipalsCastId,Tconst,Nconst,Category,JobTitle FROM PrincipalsCast WHERE PrincipalsCastId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrincipalsCast);
			selectStmt.setInt(1, PrincipalsCastId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultPrincipalsCastId = results.getInt("PrincipalsCastId");
				String tconst = results.getString("Tconst");
				String nconst = results.getString("Nconst");
				String category = results.getString("Category");
				String jobTitle = results.getString("JobTitle");
				PrincipalsCast principalsCast = new PrincipalsCast(resultPrincipalsCastId, tconst, nconst,category,jobTitle);
				return principalsCast;
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
	
	public PrincipalsCast getPrincipalsCastByNconst(String Nconst) throws SQLException{
		String selectPrincipalsCast = "SELECT PrincipalsCastId,Tconst,Nconst,Category,JobTitle FROM PrincipalsCast WHERE Nconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrincipalsCast);
			selectStmt.setString(1, Nconst);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int principalsCastId = results.getInt("PrincipalsCastId");
				String tconst = results.getString("Tconst");
				String resultNconst = results.getString("Nconst");
				String category = results.getString("Category");
				String jobTitle = results.getString("JobTitle");
				PrincipalsCast principalsCast = new PrincipalsCast(principalsCastId, tconst, resultNconst,category,jobTitle);
				return principalsCast;
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
	
	public List<PrincipalsCast> getPrincipalsCastByCategory(String  Category) throws SQLException{
		List<PrincipalsCast> principalsCasts = new ArrayList<PrincipalsCast>();
		String selectPrincipalsCast = "SELECT PrincipalsCastId,Tconst,Nconst,Category,JobTitle FROM PrincipalsCast WHERE Category=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrincipalsCast);
			selectStmt.setString(1, Category);
			results = selectStmt.executeQuery();
			while (results.next()) {
				int principalsCastId = results.getInt("PrincipalsCastId");
				String nconst = results.getString("Nconst");
				String tconst = results.getString("Tconst");
				String resultCategory = results.getString("Category");
				String jobTitle = results.getString("JobTitle");
				PrincipalsCast principalsCast = new PrincipalsCast(principalsCastId, tconst, nconst,resultCategory,jobTitle);
				principalsCasts.add(principalsCast);
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
		return principalsCasts;
	}
	public List<PrincipalsCast> getPrincipalsCastByJobTitle(String  JobTitle) throws SQLException{
		List<PrincipalsCast> principalsCasts = new ArrayList<PrincipalsCast>();
		String selectPrincipalsCast = "SELECT PrincipalsCastId,Tconst,Nconst,Category,JobTitle FROM PrincipalsCast WHERE JobTitle=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectPrincipalsCast);
			selectStmt.setString(1, JobTitle);
			results = selectStmt.executeQuery();
			while (results.next()) {
				int principalsCastId = results.getInt("PrincipalsCastId");
				String resultNconst = results.getString("Nconst");
				String tconst = results.getString("Tconst");
				String category = results.getString("Category");
				String jobTitle = results.getString("JobTitle");
				PrincipalsCast principalsCast = new PrincipalsCast(principalsCastId, tconst, resultNconst,category,jobTitle);
				principalsCasts.add(principalsCast);
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
		return principalsCasts;
	}

}
