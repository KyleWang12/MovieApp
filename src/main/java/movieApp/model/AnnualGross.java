package movieApp.model;

public class AnnualGross {
	protected int AnnualGrossId;
	protected int Year;
	protected String FilmName;
	protected int Gross;
	protected int TotalGross;
	protected int Theaters;
	protected String DistributorName;
	
	
	public AnnualGross(int annualGrossId, int year, String filmName, int gross, int totalGross, int theaters,
			String distributorName) {
	
		AnnualGrossId = annualGrossId;
		Year = year;
		FilmName = filmName;
		Gross = gross;
		TotalGross = totalGross;
		Theaters = theaters;
		DistributorName = distributorName;
	}


	public int getAnnualGrossId() {
		return AnnualGrossId;
	}


	public void setAnnualGrossId(int annualGrossId) {
		AnnualGrossId = annualGrossId;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	public String getFilmName() {
		return FilmName;
	}


	public void setFilmName(String filmName) {
		FilmName = filmName;
	}


	public int getGross() {
		return Gross;
	}


	public void setGross(int gross) {
		Gross = gross;
	}


	public int getTotalGross() {
		return TotalGross;
	}


	public void setTotalGross(int totalGross) {
		TotalGross = totalGross;
	}


	public int getTheaters() {
		return Theaters;
	}


	public void setTheaters(int theaters) {
		Theaters = theaters;
	}


	public String getDistributorName() {
		return DistributorName;
	}


	public void setDistributorName(String distributorName) {
		DistributorName = distributorName;
	}
	
	
	
	
		
	

}
