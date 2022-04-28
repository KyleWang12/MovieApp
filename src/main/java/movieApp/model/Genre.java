package movieApp.model;

/**
 * Persons is a simple, plain old java objects (POJO).
 * 
 * Persons/PersonsDao is the superclass for Administrators/AdministratorsDao and
 * BlogUsers/BlogUsersDao. Our implementation of Persons is a concrete class. This allows 
 * us to create records in the Persons MySQL table without having the associated records
 * in the Administrators or BlogUsers MySQL tables. Alternatively, Persons could be an
 * interface or an abstract class, which would force a Persons record to be created only
 * if an Administrators or BlogUsers record is created, too.
 */
public class Genre{
	protected int GenreId;
	protected String Tconst;
	protected GenreTypeEnum GenreType;
	
	public enum GenreTypeEnum {
			NEWS,
		   REALITY_TV,
		   HISTORY,
		   ROMANCE,
		   HORROR,
		   MUSIC,WAR,
		   SHORT,
		   MUSICAL,
		   DRAMA,
		   FANTASY,
		   ADULT,
		   FILM_NOIR,
		   ANIMATION,
		   COMEDY,
		   SCI_FI,
		    MYSTERY,
		    THRILLER,
		    DOCUMENTARY,
		    GAME_SHOW,
		    WESTERN,
		    BIOGRAPHY,
		    TALK_SHOW,
		    SPORT,
		    ADVENTURE,
		    FAMILY,
		    ACTION,
		    CRIME
	}

	public Genre(int genreId, String tconst, GenreTypeEnum genreType) {
		super();
		GenreId = genreId;
		Tconst = tconst;
		GenreType = genreType;
	}

	public Genre(String tconst, GenreTypeEnum genreType) {
		super();
		Tconst = tconst;
		GenreType = genreType;
	}

	public int getGenreId() {
		return GenreId;
	}

	public void setGenreId(int genreId) {
		GenreId = genreId;
	}

	public String getTconst() {
		return Tconst;
	}

	public void setTconst(String tconst) {
		Tconst = tconst;
	}

	public GenreTypeEnum getGenreType() {
		return GenreType;
	}

	public void setGenreType(GenreTypeEnum genreType) {
		GenreType = genreType;
	}
}
	
	


