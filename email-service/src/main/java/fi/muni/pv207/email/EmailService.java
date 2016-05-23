package fi.muni.pv207.email;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * @author Pavol Loffay
 */

@Path("/")
public class EmailService {

    @GET
    @Path("email")
    public Response checkDiskspace(@QueryParam("email") String email) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email) ? Response.ok().build() :
                Response.status(Response.Status.FORBIDDEN).build();
    }
}
