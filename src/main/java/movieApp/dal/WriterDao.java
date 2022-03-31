package movieApp.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import movieApp.model.*;

public class WriterDao {

	protected ConnectionManager connectionManager;
	private static WriterDao instance = null;

	protected WriterDao() {
		super();
	}

	public static WriterDao getInstance() {
		if (instance == null) {
			instance = new WriterDao();
		}
		return instance;
	}

	public Writer create(Writer writer) throws SQLException{
		String insertWriter = "INSERT INTO Writer(Tconst, Nconst) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertWriter, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, writer.getTconst());
			insertStmt.setString(2, writer.getNconst());
		
			insertStmt.executeUpdate();
			resultKey = insertStmt.getGeneratedKeys();
			int writerId = -1;
			if (resultKey.next()) {
				writerId = resultKey.getInt(1);
			} else {
				throw new SQLException("Unable to retrieve auto-generated key.");
			}
			writer.setWriterId(writerId);
			return writer;
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
	public Writer getWriterByTconst(String Tconst) throws SQLException{
		String selectWriter = "SELECT WriterId,Tconst,Nconst FROM Writer WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectWriter);
			selectStmt.setString(1, Tconst);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int writerId = results.getInt("WriterId");
				String resultTconst = results.getString("Tconst");
				String nconst = results.getString("Nconst");
				Writer writer= new Writer(writerId, resultTconst, nconst);
				return writer;
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
	public Writer getWriterByNconst(String Nconst) throws SQLException{
		String selectWriter = "SELECT WriterId,Tconst,Nconst FROM Writer WHERE Nconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectWriter);
			selectStmt.setString(1, Nconst);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int writerId = results.getInt("WriterId");
				String tconst = results.getString("Tconst");
				String resultNconst = results.getString("Nconst");
				Writer writer= new Writer(writerId, tconst, resultNconst);
				return writer;
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
	public Writer getWriterByWriterId(Integer WriterId) throws SQLException{
		String selectWriter = "SELECT WriterId,Tconst,Nconst FROM Writer WHERE WriterId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectWriter);
			selectStmt.setInt(1, WriterId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultWriterId = results.getInt("WriterId");
				String tconst = results.getString("Tconst");
				String nconst = results.getString("Nconst");
				Writer writer= new Writer(resultWriterId, tconst, nconst);
				return writer;
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
	
	public Writer delete(Writer writer) throws SQLException{
		String deleteWriter = "DELETE FROM Writer WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteWriter);
			deleteStmt.setString(1, writer.getTconst());
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
