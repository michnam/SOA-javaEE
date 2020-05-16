package pl.michnamarcin.rest;

import pl.michnamarcin.dao.UserDAO;
import pl.michnamarcin.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController
{
    @GET
    @Produces("application/json")
    @Path("/")
    public Response getUsers()
    {
        return Response.status(200)
                .entity(UserDAO.findAll())
                .build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id)
    {
        return Response.status(200)
                .entity(UserDAO.findById(id))
                .build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response addUser(User user)
    {
        UserDAO.add(user);
        return Response.status(200).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response updateUser(User user)
    {
        try
        {
            UserDAO.update(user);
        } catch(NullPointerException e)
        {
            return Response.status(400).entity("User with given id does not exist").build();
        } catch(Exception e)
        {
            return Response.status(500).build();
        }

        return Response.status(200).build();
    }


    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id)
    {
        UserDAO.delete(id);
        return Response.status(200).build();
    }


}
