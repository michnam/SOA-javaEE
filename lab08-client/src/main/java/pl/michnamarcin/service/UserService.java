package pl.michnamarcin.service;

import pl.michnamarcin.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public interface UserService
{
    @GET
    @Path("/")
    @Produces({"application/json"})
    List<User> findAllUsers();

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    User findUser(@PathParam("id") int id);

    @POST
    @Path("/")
    @Consumes({"application/json"})
    Response addUser(User user);

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    Response deleteUser(@PathParam("id") int id);

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    Response updateUser(User user);

}
