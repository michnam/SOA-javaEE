package lab05.bean;

import lab05.entity.Book;
import lab05.repository.BookRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CatalogBean implements Serializable
{
    private BookRepository bookRepository = new BookRepository();

    private String addTitle;
    private String addName;
    private String addSurname;
    private String addIsbn;
    private String addYear;
    private String addPrice;

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public void deleteBook(Book book)
    {
        bookRepository.deleteBook(book);
    }

    public String newBook()
    {


        return "book-catalog";
    }

    public String updateBook()
    {
        return null;
    }


    public String getAddTitle()
    {
        return addTitle;
    }

    public void setAddTitle(String addTitle)
    {
        this.addTitle = addTitle;
    }

    public String getAddName()
    {
        return addName;
    }

    public void setAddName(String addName)
    {
        this.addName = addName;
    }

    public String getAddSurname()
    {
        return addSurname;
    }

    public void setAddSurname(String addSurname)
    {
        this.addSurname = addSurname;
    }

    public String getAddIsbn()
    {
        return addIsbn;
    }

    public void setAddIsbn(String addIsbn)
    {
        this.addIsbn = addIsbn;
    }

    public String getAddYear()
    {
        return addYear;
    }

    public void setAddYear(String addYear)
    {
        this.addYear = addYear;
    }

    public String getAddPrice()
    {
        return addPrice;
    }

    public void setAddPrice(String addPrice)
    {
        this.addPrice = addPrice;
    }


}
