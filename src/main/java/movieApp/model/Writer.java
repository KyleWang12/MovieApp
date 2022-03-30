package movieApp.model;
public class Writer{

	protected int WriterId;
	protected String Tconst;
	protected String Nconst;
	public Writer(int writerId, String tconst, String nconst) {
		super();
		WriterId = writerId;
		Tconst = tconst;
		Nconst = nconst;
	}
	public Writer(String tconst, String nconst) {
		super();
		Tconst = tconst;
		Nconst = nconst;
	}
	public int getWriterId() {
		return WriterId;
	}
	public void setWriterId(int writerId) {
		WriterId = writerId;
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
	
	

	
}
