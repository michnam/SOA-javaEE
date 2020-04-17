package lab05.repository;

import lab05.entity.Book;

import javax.persistence.*;
import java.util.List;

public class BookRepository
{
    private EntityManager entityManager;

    public BookRepository()
    {
        entityManager = Persistence.createEntityManagerFactory("soa").createEntityManager();
    }


    public List<Book> findAll()
    {
        Query query = entityManager.createQuery("from Book");
        return query.getResultList();
    }

    public Book findById(int id)
    {
        return entityManager.find(Book.class, id);
    }

    public Book findByIsbn(String isbn) throws NoResultException
    {
        try
        {
            Query query = entityManager.createQuery("from Book where isbn=:isbn").setParameter("isbn",isbn);
            List<Book> res = query.getResultList();
            if(res.isEmpty()) throw new NoResultException("Book not found with isbn " + isbn);
            return res.get(0);
        }
        catch(Exception e)
        {
            throw new NoResultException("Book not found with isbn " + isbn);
        }
    }

    public void deleteBook(Book book)
    {
        try
        {
            Book tmp = entityManager.find(Book.class, book.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(tmp);
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't remove book");
            entityManager.getTransaction().rollback();
        }

    }

    public void addBook()
    {

    }
}
