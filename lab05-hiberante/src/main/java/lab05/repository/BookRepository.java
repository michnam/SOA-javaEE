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
        List<Book> list = query.getResultList();
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

    public void addBook(String title, String name, String surname, String isbn, int year, double price)
    {
        Book book = new Book(title, name, surname, isbn, year, price);
        try
        {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add book");
            entityManager.getTransaction().rollback();
        }
    }

    public void updateBook(int id, String title, String name, String surname, String isbn, int year, double price)
    {
        Book foundBook = entityManager.find(Book.class, id);
        System.out.println(foundBook);
        try
        {
            entityManager.getTransaction().begin();
            foundBook.setTitle(title);
            foundBook.setAuthorName(name);
            foundBook.setAuthorSurname(surname);
            foundBook.setIsbn(isbn);
            foundBook.setPublicationYear(year);
            foundBook.setPrice(price);
            entityManager.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Couldn't update book");
            entityManager.getTransaction().rollback();
        }
    }
}
