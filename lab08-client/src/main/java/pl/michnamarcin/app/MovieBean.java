package pl.michnamarcin.app;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import pl.michnamarcin.entity.Movie;
import pl.michnamarcin.entity.User;
import pl.michnamarcin.service.MovieService;
import pl.michnamarcin.service.UserService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MovieBean implements Serializable
{
    private ResteasyClient client = new ResteasyClientBuilder().build();
    private ResteasyWebTarget target = client.target(UriBuilder.fromPath("http://localhost:8080/rest"));
    private MovieService proxy = target.proxy(MovieService.class);
    private UserService proxyUser = target.proxy(UserService.class);

    private Movie toAdd = new Movie();
    private Movie toUpdate = new Movie();
    private String userId;

    public List<Movie> findAllMovies()
    {
        List<Movie> movies = proxy.findAllMovies();
        return movies;
    }


    public void deleteMovie(Movie movie)
    {
        Response movieResponse = proxy.deleteMovie(movie.getId());
        System.out.println("HTTP code: " + movieResponse.getStatus());
        movieResponse.close();
    }


    public String goUpdate(Movie movie)
    {
        toUpdate = movie;
        return "update-movie";
    }

    public String addMovie()
    {
        int id = Integer.parseInt(userId.split(" ")[1]);


        proxy.addMovie(id, toAdd);
        toAdd = new Movie();
        return "movies";
    }

    public String updateMovie()
    {
        proxy.updateMovie(toUpdate);
        return "movies";
    }

    public List<User> getUsers()
    {
        return proxyUser.findAllUsers();
    }





    public Movie getToAdd()
    {
        return toAdd;
    }

    public void setToAdd(Movie toAdd)
    {
        this.toAdd = toAdd;
    }

    public Movie getToUpdate()
    {
        return toUpdate;
    }

    public void setToUpdate(Movie toUpdate)
    {
        this.toUpdate = toUpdate;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }
}
