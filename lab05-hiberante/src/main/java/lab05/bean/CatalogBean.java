package lab05.bean;

import lab05.entity.Book;
import lab05.repository.BookRepository;

import javax.annotation.PostConstruct;
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
    private int addYear;
    private double addPrice;

    private int updateId;
    private String updateTitle;
    private String updateName;
    private String updateSurname;
    private String updateIsbn;
    private int updateYear;
    private double updatePrice;

    @PostConstruct
    public void init()
    {
        addTitle = "";
        addName = "";
        addSurname = "";
        addIsbn = "";
        addYear = 2020;
        addPrice = 9.99;
    }

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
        bookRepository.addBook(addTitle, addName, addSurname, addIsbn, addYear, addPrice);
        addTitle = "";
        addName = "";
        addSurname = "";
        addIsbn = "";
        addYear = 2020;
        addPrice = 9.99;
        return "book-catalog";
    }

    public String updateBook()
    {
        bookRepository.updateBook(updateId, updateTitle, updateName, updateSurname, updateIsbn, updateYear, updatePrice);
        return "book-catalog";
    }


    public String updateBookPage(int updateId, String updateTitle, String updateName, String updateSurname, String updateIsbn, int updateYear, double updatePrice)
    {
        this.updateId = updateId;
        this.updateTitle = updateTitle;
        this.updateName = updateName;
        this.updateSurname = updateSurname;
        this.updateIsbn = updateIsbn;
        this.updateYear = updateYear;
        this.updatePrice = updatePrice;

        return "update-book";
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


    public int getAddYear()
    {
        return addYear;
    }

    public void setAddYear(int addYear)
    {
        this.addYear = addYear;
    }

    public double getAddPrice()
    {
        return addPrice;
    }

    public void setAddPrice(double addPrice)
    {
        this.addPrice = addPrice;
    }

    public String getUpdateTitle()
    {
        return updateTitle;
    }

    public void setUpdateTitle(String updateTitle)
    {
        this.updateTitle = updateTitle;
    }

    public String getUpdateName()
    {
        return updateName;
    }

    public void setUpdateName(String updateName)
    {
        this.updateName = updateName;
    }

    public String getUpdateSurname()
    {
        return updateSurname;
    }

    public void setUpdateSurname(String updateSurname)
    {
        this.updateSurname = updateSurname;
    }

    public String getUpdateIsbn()
    {
        return updateIsbn;
    }

    public void setUpdateIsbn(String updateIsbn)
    {
        this.updateIsbn = updateIsbn;
    }

    public int getUpdateYear()
    {
        return updateYear;
    }

    public void setUpdateYear(int updateYear)
    {
        this.updateYear = updateYear;
    }

    public double getUpdatePrice()
    {
        return updatePrice;
    }

    public void setUpdatePrice(double updatePrice)
    {
        this.updatePrice = updatePrice;
    }

    public int getUpdateId()
    {
        return updateId;
    }

    public void setUpdateId(int updateId)
    {
        this.updateId = updateId;
    }
}
