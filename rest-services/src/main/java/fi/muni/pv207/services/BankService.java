package fi.muni.pv207.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Pavol Loffay
 */
@Path("/")
public class BankService {

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    @POST
    @Path("bank")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendBack(Double money) {
        logger.info("Bank request");

        return Response.ok().build();
    }
}
