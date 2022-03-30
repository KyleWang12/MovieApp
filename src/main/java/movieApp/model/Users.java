package movieApp.model;
public class Users {
	protected int UserId;
	protected String UserName;
	protected String Password;
	protected String FirstName;
	protected String LastName;
	protected String Phone;
	protected String Email;
	public Users(int userId, String userName, String password, String firstName, String lastName, String phone,
			String email) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
	}
	public Users(String userName, String password, String firstName, String lastName, String phone, String email) {
		super();
		UserName = userName;
		Password = password;
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
}
