package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	public boolean edit(String oldisbn, String isbn, String name, int year, String author,
			String area, String status, int quantity) {

		boolean output = false;
		try {
			
			Base data = new Base();
			
			// create a mysql database connection
			Class.forName(data.getDriver());
			Connection conn = DriverManager.getConnection(data.getURL(), data.getUser(), data.getPassword());
			String query = "UPDATE books SET "
					+ "isbn = ?, "
					+ "name = ?, "
					+ "year = ?, "
					+ "author = ?, "
					+ "area = ?, "
					+ "status = ?, "
					+ "quantity = ? "
					+ "WHERE isbn = ?";
			// create the java mysql update preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, isbn);
            preparedStmt.setString(2, name);
        	preparedStmt.setInt(3, year);
            preparedStmt.setString(4, author);
            preparedStmt.setString(5, area);
            preparedStmt.setString(6, status);
            preparedStmt.setInt(7, quantity);
            preparedStmt.setString(8, oldisbn);

			// execute the preparedstatement
			preparedStmt.execute();
			
			conn.close();
			
			output = true;
			
		} catch (Exception e) {
			System.out.println("Got an exception! - database/Update.java - 1");
			System.out.println(e.getMessage());
		}
		
		return output;
	}
}
