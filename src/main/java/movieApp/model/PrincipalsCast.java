package movieApp.model;
public class PrincipalsCast{
	protected int PrincipalsCastId;
	protected String Tconst;
	protected String Nconst;
	protected String Category;
	protected String JobTitle;
	public PrincipalsCast(int principalsCastId, String tconst, String nconst, String category, String jobTitle) {
		super();
		PrincipalsCastId = principalsCastId;
		Tconst = tconst;
		Nconst = nconst;
		Category = category;
		JobTitle = jobTitle;
	}
	public PrincipalsCast(String tconst, String nconst, String category, String jobTitle) {
		super();
		Tconst = tconst;
		Nconst = nconst;
		Category = category;
		JobTitle = jobTitle;
	}

	public int getPrincipalsCastId() {
		return PrincipalsCastId;
	}
	public void setPrincipalsCastId(int principalsCastId) {
		PrincipalsCastId = principalsCastId;
	}
	public String getTconst() {
		return Tconst;
	}
	public void setTconst(String tconst) {
		Tconst = tconst;
	}
	public String getNconst() {
		return Nconst;
	}
	public void setNconst(String nconst) {
		Nconst = nconst;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	
	
}
