package dao;

import entity.Author;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AuthorDAO
{
    private EntityManager em;

    public AuthorDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Author> findAll()
    {
        Query query = em.createQuery("from Author ");
        return  query.getResultList();
    }

    public Author findById(int id)
    {
        return em.find(Author.class, id);
    }

    public void addAuthor(Author toAdd)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add author");
            em.getTransaction().rollback();
        }
    }

    public void updateAuthor(Author updatedAuthor)
    {
        Author author = em.find(Author.class, updatedAuthor.getId());
        try
        {
            em.getTransaction().begin();
            author.setAuthorName(updatedAuthor.getAuthorName());
            author.setAuthorSurname(updatedAuthor.getAuthorSurname());
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update user");
            em.getTransaction().rollback();
        }
    }
}
