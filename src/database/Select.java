package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import json.BookTrack;
import json.Track;

public class Select {

	public BookTrack get(String isbn) {

		BookTrack output = new BookTrack();
		try {
			
			Base data = new Base();
			
			// create a mysql database connection
			Class.forName(data.getDriver());
			Connection conn = DriverManager.getConnection(data.getURL(), data.getUser(), data.getPassword());

			String query = "SELECT * FROM books WHERE ISBN = '" + isbn + "'";
			
			// create the java statement
			Statement st = conn.createStatement();
			
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			
			// iterate through the java resultset
			if(rs.first()){

				output.setISBN(rs.getString("ISBN"));
				output.setName(rs.getString("name"));
				output.setYear(rs.getString("year"));
				output.setAuthor(rs.getString("author"));
				output.setArea(rs.getString("area"));
				output.setStatus(rs.getString("status"));
				output.setQuantity(rs.getString("quantity"));
				
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Got an exception! - database/Select.java - 1");
			System.out.println(e.getMessage());
		}
		
		return output;
	}

	public Track[] getAll() {

		Track[] output = null;
		try {
			
			Base data = new Base();
			
			// create a mysql database connection
			Class.forName(data.getDriver());
			Connection conn = DriverManager.getConnection(data.getURL(), data.getUser(), data.getPassword());

			String query1 = "SELECT count(*) FROM books";
			String query2 = "SELECT ISBN,name FROM books";
			// create the java statement
			Statement st = conn.createStatement();
			
			// Get the size of the result
			ResultSet rs = st.executeQuery(query1);
			if(rs.first()){
				int size = rs.getInt("count(*)");
				output = new Track[size];
				
				// execute the query, and get a java resultset
				rs = st.executeQuery(query2);
				
				// iterate through the java resultset
				for(int i = 0; rs.next(); i++){

					Track t = new Track();
					t.setISBN(rs.getString("ISBN"));
					t.setName(rs.getString("name"));
					output[i] = t;
					
				}
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Got an exception! - database/Select.java - 1");
			System.out.println(e.getMessage());
		}
		
		return output;
	}
}
