package mvccrudpackage.model.bean;

/*
 * uid = 1 
 * lastname = AdminFirst 
 * firstname = AdminLast
 * username = Admin
 * pass = pass1
 */


public class Login {

	private String username;
	private String pass;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
		
	}
	
}
