package movieapp.model;

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
public class Film {
	protected String Tconst;
	protected String FilmName;
	protected int ReleaseDate;
	protected boolean isAdult;
	protected String title;
	
	public Film(String tconst, String filmName, int releaseDate, boolean isAdult, String title) {
		Tconst = tconst;
		FilmName = filmName;
		ReleaseDate = releaseDate;
		this.isAdult = isAdult;
		this.title = title;
	}

	public String getTconst() {
		return Tconst;
	}

	public void setTconst(String tconst) {
		Tconst = tconst;
	}

	public String getFilmName() {
		return FilmName;
	}

	public void setFilmName(String filmName) {
		FilmName = filmName;
	}

	public int getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		ReleaseDate = releaseDate;
	}

	public boolean isAdult() {
		return isAdult;
	}

	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
	
	


