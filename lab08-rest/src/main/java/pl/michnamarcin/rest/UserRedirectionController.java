package pl.michnamarcin.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/osoby")
public class UserRedirectionController
{
    @GET
    @Produces("application/json")
    @Path("/")
    public Response getUsers() throws URISyntaxException
    {
        return Response.status(302).location(new URI("/users")).build();
    }
}
