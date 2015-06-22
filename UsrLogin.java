//imasSetiawanRaharja (13410100227)
public class UsrLogin
{
	private String usrName;
	private String pass;
	
	public UsrLogin(String usrName, String pass)
	{
		this.usrName = usrName;
		this.pass = pass;
	}
	
	public String getUserName()
	{
		return usrName;
	}
	
	public String getPassword()
	{
		return pass;
	}
	
	
	public boolean checkPassUser(String user, String passwd)
	{
		return (user.equals(usrName) && (passwd.equals(pass)));
	}
	
	public void setPassword(String passwd)
	{
		pass = passwd;
	}
}
