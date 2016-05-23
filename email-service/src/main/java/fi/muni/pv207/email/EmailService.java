package fi.muni.pv207.email;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author Pavol Loffay
 */

@Path("/")
public class EmailService {

    @GET
    @Path("email")
    public Response checkDiskspace(@QueryParam("email") String email) {
        return Response.ok().build();
    }
}
