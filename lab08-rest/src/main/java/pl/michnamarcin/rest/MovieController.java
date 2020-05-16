package pl.michnamarcin.rest;

import pl.michnamarcin.dao.MovieDAO;
import pl.michnamarcin.dao.UserDAO;
import pl.michnamarcin.entity.Movie;
import pl.michnamarcin.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieController
{
    @GET
    @Produces("application/json")
    @Path("/")
    public Response getMovies()
    {
        return Response.status(200)
                .entity(MovieDAO.findAll())
                .build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getMovie(@PathParam("id") int id)
    {
        return Response.status(200)
                .entity(MovieDAO.findById(id))
                .build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response addMovie(Movie movie)
    {
        MovieDAO.add(movie);
        return Response.status(200).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response updateMovie(Movie movie)
    {
        try
        {
            MovieDAO.update(movie);
        } catch(NullPointerException e)
        {
            return Response.status(400).entity("Movie with given id does not exist").build();
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
    public Response deleteMovie(@PathParam("id") int id)
    {
        MovieDAO.delete(id);
        return Response.status(200).build();
    }

    @GET
    @Produces("application/json")
    @Path("/")
    public Response getMoviesByTitle(@QueryParam("title") String title) {
        return Response.status(200)
                .entity(MovieDAO.getMovieByTitle(title))
                .build();
    }

    @PUT
    @Produces("application/json")
    @Path("/{id}")
    public Response updateUri(@PathParam("id") int id, @QueryParam("uri") String uri)
    {
        try
        {
            MovieDAO.updateMovieUri(id, uri);
        } catch(NullPointerException e)
        {
            return Response.status(400).entity("Movie with given id does not exist").build();
        } catch(Exception e)
        {
            return Response.status(500).build();
        }

        return Response.status(200).build();
    }

}
