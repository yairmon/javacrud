package crud;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.Select;
import json.BookTrack;
import json.Track;

@Path("/read")
public class Read {

	// This returns a Track of Tracks, which stands for the Json in Jersey
	@GET
	@Path("/showallbooks")
	@Produces(MediaType.APPLICATION_JSON)
    public Track[] seeBooks() {
		Select s = new Select();
		return s.getAll();
    }

	// This returns a BookTrack, which is the same than Track but just adding more parameters
	@GET
	@Path("/{isbn}")
	@Produces(MediaType.APPLICATION_JSON)
    public BookTrack seeSpecificBook(@PathParam("isbn") String isbn) {
		Select s = new Select();
		return s.get(isbn);
    }

}
