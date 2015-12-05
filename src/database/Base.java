package database;

public class Base {
	private String URL;
	private String database;
	private String user;
	private String password;
	private String driver;

	public Base() {
		URL = "jdbc:mysql://localhost/";
		database = "data";
		user = "root";
		password = "";
		driver = "org.gjt.mm.mysql.Driver"; 
	}

	public String getURL() {
		return URL+database;
	}

	public String getDatabase() {
		return database;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	public String getDriver() {
		return driver;
	}
	
	
	
}
