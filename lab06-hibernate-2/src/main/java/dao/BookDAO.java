package dao;

import entity.Author;
import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookDAO
{
    private EntityManager em;

    public BookDAO()
    {
        em = Persistence.createEntityManagerFactory("soa6").createEntityManager();
    }

    public List<Book> findAll()
    {
        Query query = em.createQuery("from Book ");
        return  query.getResultList();
    }

    public Book findByIsbn(String isbn)
    {
        return em.find(Book.class, isbn);
    }
}
