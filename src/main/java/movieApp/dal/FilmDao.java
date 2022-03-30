package movieApp.dal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movieApp.model.*;

public class FilmDao {
	
	
	
	
	public Film create(Film film) throws SQLException{
		
		return new Film();
	}
	public Film getFilmByTconst(String Tconst) throws SQLException {
		return new Film();
	}
	public List<Film> getFilmByFilmName(String FilmName) throws SQLException{
		return new ArrayList<Film>();
	}
	public List<Film> getFilmByReleaseDate(int ReleaseDate) throws SQLException{
		return new ArrayList<Film>();
	}
	public List<Film> getFilmByisAdult(boolean isAdult) throws SQLException{
		return new ArrayList<Film>();
	}
	public Film delete(Film film) throws SQLException{
		return new Film();
	}
	
	public Film updateFilmName(Film film, String newFilmName) throws SQLException{
		return new Film();
	}


}