package movieApp.dal;

import movieApp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Data access object (DAO) class to interact with the underlying Persons table in your MySQL
 * instance. This is used to store {@link Persons} into your MySQL instance and retrieve 
 * {@link Persons} from MySQL instance.
 */
public class GenreDao {
	protected ConnectionManager connectionManager;
	
	private static GenreDao instance = null;
	protected GenreDao() {
		connectionManager = new ConnectionManager();
	}
	public static GenreDao getInstance() {
		if(instance == null) {
			instance = new GenreDao();
		}
		return instance;
	}

	
	public Genre create(Genre genre) throws SQLException {
		String insertGenre = "INSERT INTO Genre(Tconst,GenreType) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertGenre);
		
			insertStmt.setString(1, genre.getTconst());
			insertStmt.setString(2, genre.getGenreType().name());

			insertStmt.executeUpdate();
			
			return genre;
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
	
	public Genre getGenreByTconst(String Tconst) throws SQLException {
		String selectT = "SELECT GenreId,Tconst,GenreType FROM Genre WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectT);
			selectStmt.setString(1, Tconst);
			
			results = selectStmt.executeQuery();
		
			if(results.next()) {
				int id = results.getInt("GenreId");
				String tc = results.getString("Tconst");
				Genre.GenreTypeEnum gte =Genre.GenreTypeEnum.valueOf(results.getString("GenreType").toUpperCase());
				Genre g = new Genre(id, tc,gte);
				return g;
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
	
	public List<Film> getFilmByGenre(Genre.GenreTypeEnum GenreType) throws SQLException{
		List<Film> fList = new ArrayList<>();
		String selectG = "SELECT Film.Tconst AS Tconst,Film.FilmName AS FilmName,"
				+ "Film.ReleaseDate AS ReleaseDate,Film.isAdult AS isAdult,Film.title AS title FROM "
				+ "Genre INNER JOIN Film "
				+ "ON Genre.Tconst = Film.Tconst "
				+ "WHERE Genre.Tconst=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectG);
			selectStmt.setString(1, GenreType.name());
			
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
	
	public Genre updateGenreType(Genre genre, Genre.GenreTypeEnum GenreType) throws SQLException{
		String updateG = "UPDATE Genre SET GenreType=? WHERE Tconst=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateG);
			updateStmt.setString(1, GenreType.name());
			updateStmt.setString(2, genre.getTconst());
			updateStmt.executeUpdate();
			
			genre.setGenreType(GenreType);
			return genre;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	
	public Genre delete(Genre genre) throws SQLException {
		String deleteG = "DELETE FROM Genre WHERE GenreId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteG);
			deleteStmt.setInt(1, genre.getGenreId());
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
