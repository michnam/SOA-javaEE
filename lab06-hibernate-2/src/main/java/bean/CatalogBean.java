package bean;

import dao.BookDAO;
import dao.CatalogDAO;
import entity.Book;
import entity.Catalog;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CatalogBean implements Serializable
{
    private CatalogDAO catalogDAO = new CatalogDAO();
    private BookDAO bookDAO = new BookDAO();

    private Catalog toAdd = new Catalog();
    private Catalog toUpdate;
    private String chosenBook;

    public List<Catalog> getAllCatalog()
    {
        return catalogDAO.findAll();
    }
    public List<Book> getBooks() {return bookDAO.findAll(); }

    public String goAdd()
    {
        toAdd = new Catalog();
        return "add-catalog";
    }

    public String goUpdate(Catalog catalog)
    {
        toUpdate = catalog;
        return "update-catalog";
    }

    public String addCatalog()
    {

        String isbn = chosenBook.split(" ")[1];
        toAdd.setBook(bookDAO.findByIsbn(isbn));
        catalogDAO.addCatalog(toAdd);
        return "catalog";
    }

    public String updateCatalog()
    {
        catalogDAO.updateCatalog(toUpdate);
        return "catalog";
    }

    public Catalog getToAdd()
    {
        return toAdd;
    }

    public void setToAdd(Catalog toAdd)
    {
        this.toAdd = toAdd;
    }

    public Catalog getToUpdate()
    {
        return toUpdate;
    }

    public void setToUpdate(Catalog toUpdate)
    {
        this.toUpdate = toUpdate;
    }

    public String getChosenBook()
    {
        return chosenBook;
    }

    public void setChosenBook(String chosenBook)
    {
        this.chosenBook = chosenBook;
    }
}
