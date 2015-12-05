package crud;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/delete")
public class Delete {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		return "Hello this is Delete ...";
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
    public String deleteteBook(@FormParam("isbn") String isbn) {

		// We need to reference what package is Delete-Model in.
		database.Delete db = new database.Delete();
		
		return db.delete(isbn) ? "Success" : "Internal server error";
		
    }

}
