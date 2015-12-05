package crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.Insert;

@Path("/create")
public class Create {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		return "Hello this is Create ...";
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
    public String createBook(@FormParam("isbn") String isbn,@FormParam("name") String name,
    		@FormParam("year") String year,@FormParam("author") String author,
    		@FormParam("area") String area,@FormParam("status") String status,
    		@FormParam("quantity") String quantity) {
		
		String output = "";
		int newYear = 0;
		int newQuantity = 0;
		
		if(isbn.equals(""))
			output = "ISBN cannot be empty.\n";
		
		try {
			if(!year.equals(""))
				newYear = Integer.parseInt(year);
		} catch (Exception e) {
			output = "Year must be a valid number.\n";
		}
		
		try {
			if(!quantity.equals(""))
				newQuantity = Integer.parseInt(quantity);
		} catch (Exception e) {
			output = "Quantity must be a valid number.\n";
		}
		
		if(output.equals("")){
			
			Insert db = new Insert();
			
			if(db.put(isbn, name, newYear, author, area, status, newQuantity))
				output = "Success";
			else output = "ISBN already exists";
			
		}
		
		return output;
		
    }

}
