package fi.muni.pv207.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Pavol Loffay
 */
@Path("/")
public class BankService {

    @POST
    @Path("bank")
    public Response sendBack(Double money) {
        return Response.ok().build();
    }
}
