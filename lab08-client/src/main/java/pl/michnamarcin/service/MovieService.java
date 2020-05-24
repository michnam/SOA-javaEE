package pl.michnamarcin.service;

import pl.michnamarcin.entity.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies")
public interface MovieService
{
    @GET
    @Path("/")
    @Produces({"application/json"})
    List<Movie> findAllMovies();


//    @GET
//    @Path("/{id}")
//    @Produces({"application/java"})
//    Movie findMovie(@PathParam("id") int id);

    @POST
    @Path("/{id}")
    @Consumes({"application/json"})
    Response addMovie(@PathParam("id") int id, Movie movie);

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    Response deleteMovie(@PathParam("id") int id);

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    Response updateMovie(Movie movie);
}
