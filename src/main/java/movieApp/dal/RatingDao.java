package movieApp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movieApp.model.Rating;

public class RatingDao {
	protected ConnectionManager connectionManager;
	
	private static RatingDao instance = null;

	protected RatingDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static RatingDao getInstance() {
		if(instance == null) {
			instance = new RatingDao();
		}
		return instance;	
	}
	
	public Rating create(Rating rating) throws SQLException{
		String insertRating = "INSERT INTO RATING(Tconst, averageRating, numVotes VALUES(?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertRating);
			
			insertStmt.setString(1,rating.getTconst());
			insertStmt.setDouble(2, rating.getAverageRating());
			insertStmt.setInt(3, rating.getNumVotes());
			insertStmt.executeUpdate();
			
			return rating;
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
	
	public Rating getRatingByTconst(String Tconst) throws SQLException{
		String selectUser = "SELECT Tconst,averageRating, numVotes FROM Rating WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectUser);
			selectStmt.setString(1, Tconst);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String tc = results.getString("Tconst");
				Double ar = results.getDouble("averageRating");
				int nv = results.getInt("numVotes");
				Rating r = new Rating(tc,ar,nv);
				
				return r;
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
	
  public Rating getRatingByAveragerating(Double averageRating) throws SQLException{
	  String selectRes = "SELECT Tconst,averageRating, numVotes FROM Rating WHERE averageRating=?;"; 
	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	  try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setDouble(1, averageRating);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String tc = results.getString("Tconst");
				Double ar = results.getDouble("averageRating");
				int nv = results.getInt("numVotes");
				Rating r = new Rating(tc,ar,nv);
				
				return r;
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
  
  public Rating getRatingByNumVotes(int numVotes) throws SQLException{
	  String selectRes = "SELECT Tconst,averageRating, numVotes FROM Rating WHERE averageRating=?;"; 
	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	  try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, numVotes);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String tc = results.getString("Tconst");
				Double ar = results.getDouble("averageRating");
				int nv = results.getInt("numVotes");
				Rating r = new Rating(tc,ar,nv);
				
				return r;
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
  
  public Rating delete(Rating rating) throws SQLException{
	  String deleteUser = "DELETE FROM Rating WHERE Tconst=?;";
	  Connection connection = null;
	  PreparedStatement deleteStmt = null;
	  
      try {
		connection = connectionManager.getConnection();
		deleteStmt = connection.prepareStatement(deleteUser);
		deleteStmt.setString(1, rating.getTconst());
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
