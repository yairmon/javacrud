package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {

	public boolean delete(String isbn) {

		boolean output = false;
		try {
			
			Base data = new Base();
			
			// create a mysql database connection
			Class.forName(data.getDriver());
			Connection conn = DriverManager.getConnection(data.getURL(), data.getUser(), data.getPassword());
			
			// create the mysql delete statement.
			String query = "DELETE FROM books WHERE isbn = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, isbn);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
			
			output = true;
			
		} catch (Exception e) {
			System.out.println("Got an exception! - database/Delete.java - 1");
			System.out.println(e.getMessage());
		}
		
		return output;
	}
}
