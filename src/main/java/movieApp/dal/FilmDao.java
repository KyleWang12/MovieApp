package movieapp.dal;

import movieapp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Data access object (DAO) class to interact with the underlying Persons table in your MySQL
 * instance. This is used to store {@link Film} into your MySQL instance and retrieve 
 * {@link Film} from MySQL instance.
 */
public class FilmDao {
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static FilmDao instance = null;
	protected FilmDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static FilmDao getInstance() {
		if(instance == null) {
			instance = new FilmDao();
		}
		return instance;
	}

	
	public Film create(Film film) throws SQLException {
		String insertFilm = "INSERT INTO film(Tconst,FilmName,ReleaseDate,isAdult,title) VALUES(?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertFilm);
			
			insertStmt.setString(1,film.getTconst());
			insertStmt.setString(2, film.getFilmName());
			insertStmt.setInt(3, film.getReleaseDate());
			insertStmt.setBoolean(4, film.isAdult());
			insertStmt.setString(5, film.getTitle());
			insertStmt.executeUpdate();
			
			return film;
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
	
	
	public Film getFilmByTconst(String Tconst) throws SQLException {
		String selectUser = "SELECT Tconst,FilmName,ReleaseDate,isAdult,title FROM Film WHERE Tconst=?;";
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
				String fn = results.getString("FilmName");
				int rd = results.getInt("ReleaseDate");
				boolean ia = results.getBoolean("isAdult");
				String ti = results.getString("Title");
				Film f = new Film(tc,fn,rd,ia,ti);
				
				return f;
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
	
	public Film getFilmByFilmName(String FilmName) throws SQLException{
		String selectRes = "SELECT Tconst,FilmName,ReleaseDate,isAdult,title FROM Film WHERE FilmName=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setString(1, FilmName);
			
			results = selectStmt.executeQuery();
			
			if(results.next()) {
				String tc = results.getString("Tconst");
				String fn = results.getString("FilmName");
				int rd = results.getInt("ReleaseDate");
				boolean ia = results.getBoolean("isAdult");
				String ti = results.getString("Title");
				Film f = new Film(tc,fn,rd,ia,ti);
				
				return f;
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
	
	
	public List<Film> getFilmByReleaseDate(int ReleaseDate) throws SQLException{
		List<Film> fList = new ArrayList<>();
		String selectRes = "SELECT Tconst,FilmName,ReleaseDate,isAdult,title FROM Film WHERE ReleaseDate=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setInt(1, ReleaseDate);
			
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				String tc = results.getString("Tconst");
				String fn = results.getString("FilmName");
				int rd = results.getInt("ReleaseDate");
				boolean ia = results.getBoolean("isAdult");
				String ti = results.getString("Title");
				Film f = new Film(tc,fn,rd,ia,ti);
				fList.add(f);
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
		return fList;
	}
	
	
	public List<Film> getFilmByisAdult(boolean isAdult) throws SQLException{
		List<Film> fList = new ArrayList<>();
		String selectRes = "SELECT Tconst,FilmName,ReleaseDate,isAdult,title FROM Film WHERE isAdult=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectRes);
			selectStmt.setBoolean(1, isAdult);
			
			results = selectStmt.executeQuery();
			
			while(results.next()) {
				String tc = results.getString("Tconst");
				String fn = results.getString("FilmName");
				int rd = results.getInt("ReleaseDate");
				boolean ia = results.getBoolean("isAdult");
				String ti = results.getString("Title");
				Film f = new Film(tc,fn,rd,ia,ti);
				fList.add(f);
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
		return fList;
	}
		
	
	public Film delete(Film film) throws SQLException {
		String deleteUser = "DELETE FROM Film WHERE FilmName=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteUser);
			deleteStmt.setString(1, film.getFilmName());
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
