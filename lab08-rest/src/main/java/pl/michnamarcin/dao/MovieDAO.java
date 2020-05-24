package pl.michnamarcin.dao;


import pl.michnamarcin.entity.Movie;
import pl.michnamarcin.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class MovieDAO
{
    private static EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();

    public static List<Movie> findAll()
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        return em.createQuery("from Movie").getResultList();
    }

    public static Movie findById(int id)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        return em.find(Movie.class, id);
    }

    public static void add(Movie toAdd, int id)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        try
        {
            toAdd.setUser(em.find(User.class, id));
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add movie");
            em.getTransaction().rollback();
        }
    }

    public static void update(Movie updatedMovie)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        Movie movie = em.find(Movie.class, updatedMovie.getId());
        try
        {
            em.getTransaction().begin();
            movie.setTitle(updatedMovie.getTitle());
            movie.setUri(updatedMovie.getUri());
            if(updatedMovie.getUser() != null)
                movie.setUser(updatedMovie.getUser());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update movie");
            em.getTransaction().rollback();
        }
    }

    public static void delete(int id)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        try
        {
            Movie tmp = em.find(Movie.class, id);
            em.getTransaction().begin();
            em.remove(tmp);
            em.getTransaction().commit();
        } catch(Exception e)
        {
            System.out.println("Couldn't remove movie");
            em.getTransaction().rollback();
        }
    }

    public static List<Movie> getMovieByTitle(String title)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        return em.createQuery("from Movie where lower(title) LIKE lower(:title)").setParameter("title", "%" + title + "%").getResultList();
    }

    public static void updateMovieUri(int id, String uri)
    {
        //EntityManager em = Persistence.createEntityManagerFactory("soa").createEntityManager();
        try
        {
            Movie movie = em.find(Movie.class, id);

            em.getTransaction().begin();
            movie.setUri(uri);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update movie");
            em.getTransaction().rollback();
        }
    }

}
