package movieApp.model;

public class Distributor {
	protected String DistributorName;
	protected int MoviesQuantity;
	public Distributor(String distributorName, int moviesQuantity) {
		
		DistributorName = distributorName;
		MoviesQuantity = moviesQuantity;
	}
	
	
	public String getDistributorName() {
		return DistributorName;
	}
	public void setDistributorName(String distributorName) {
		DistributorName = distributorName;
	}
	public int getMoviesQuantity() {
		return MoviesQuantity;
	}
	public void setMoviesQuantity(int moviesQuantity) {
		MoviesQuantity = moviesQuantity;
	}
	
	
	


}
