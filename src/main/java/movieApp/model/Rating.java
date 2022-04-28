package movieApp.model;

public class Rating {
	protected String Tconst;
	protected Double averageRating;
	protected int numVotes;
	
	public Rating(String tconst, Double averageRating, int numVotes) {
		
		Tconst = tconst;
		this.averageRating = averageRating;
		this.numVotes = numVotes;
	}

	public String getTconst() {
		return Tconst;
	}

	public void setTconst(String tconst) {
		Tconst = tconst;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	
	
	
	

}
