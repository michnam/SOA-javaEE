package bean;

import dao.*;
import entity.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class BorrowBean implements Serializable
{
    private BorrowDAO borrowDAO = new BorrowDAO();
    private CatalogDAO catalogDAO = new CatalogDAO();
    private UserDAO userDAO = new UserDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private BookDAO bookDAO = new BookDAO();
    private EntityManager em = Persistence.createEntityManagerFactory("soa6").createEntityManager();

    private Borrow toAdd;
    private Borrow toUpdate;
    private String chosenCatalog;
    private String chosenUser;
    private String returnDate;
    private String rentDate;

    public BorrowBean()
    {
    }

    public List<Borrow> getAllRental()
    {
        return borrowDAO.findAll();
    }
    public List<User> getAllUser() { return  userDAO.findAll(); }
    public List<Catalog> getAllCatalog() { return  catalogDAO.findAll(); }
    public List<Author> getAllAuthors() { return authorDAO.findAll(); }
    public List<Book> getAllBook() {return bookDAO.findAll(); }

    public String goUpdate(Borrow borrow)
    {
        toUpdate = borrow;
        chosenCatalog = toUpdate.getCatalog().toString();
        chosenUser = toUpdate.getUser().toString();
        rentDate = toUpdate.getRentDate().toString();
        if(toUpdate.getReturnDate() != null) returnDate = toUpdate.getReturnDate().toString();
        return "update-borrowing";
    }

    public String goAdd()
    {
        toAdd = new Borrow();
        return "add-borrowing";
    }

    public String addBorrow()
    {
        toAdd = new Borrow();
        if(!returnDate.equals(""))
        {
            try
            {
                toAdd.setReturnDate(Date.valueOf(returnDate));
            }
            catch(Exception e)
            {
                System.out.println("Couldn't parse return date.");
            }
        }

        int catalogID = Integer.parseInt(chosenCatalog.split(" ")[1]);
        int userID = Integer.parseInt(chosenUser.split(" ")[1]);

        toAdd.setUser(userDAO.findById(userID));
        toAdd.setCatalog(catalogDAO.findById(catalogID));
        try
        {
            toAdd.setRentDate(Date.valueOf(rentDate));
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add borrow - wrong borrow date");
            e.printStackTrace();
        }


        borrowDAO.add(toAdd);
        return "index";
    }

    public String updateBorrow()
    {
        if(!returnDate.equals(""))
        {
            try
            {
                toUpdate.setReturnDate(Date.valueOf(returnDate));
            }
            catch(Exception e)
            {
                System.out.println("Couldn't parse return date.");
            }
        }

        int catalogID = Integer.parseInt(chosenCatalog.split(" ")[1]);
        int userID = Integer.parseInt(chosenUser.split(" ")[1]);

        toUpdate.setUser(userDAO.findById(userID));
        toUpdate.setCatalog(catalogDAO.findById(catalogID));

        try
        {
            toUpdate.setRentDate(Date.valueOf(rentDate));
        }
        catch(Exception e)
        {
            System.out.println("Couldn't add borrow - wrong borrow date");
            e.printStackTrace();
        }
        borrowDAO.update(toUpdate);
        return "index";
    }

    public void deleteBorrow(Borrow borrow)
    {
        borrowDAO.delete(borrow);
    }

    public Borrow getToAdd()
    {
        return toAdd;
    }

    public void setToAdd(Borrow toAdd)
    {
        this.toAdd = toAdd;
    }

    public Borrow getToUpdate()
    {
        return toUpdate;
    }

    public void setToUpdate(Borrow toUpdate)
    {
        this.toUpdate = toUpdate;
    }

    public String getChosenCatalog()
    {
        return chosenCatalog;
    }

    public void setChosenCatalog(String chosenCatalog)
    {
        this.chosenCatalog = chosenCatalog;
    }

    public String getChosenUser()
    {
        return chosenUser;
    }

    public void setChosenUser(String chosenUser)
    {
        this.chosenUser = chosenUser;
    }

    public String getReturnDate()
    {
        return returnDate;
    }

    public void setReturnDate(String returnDate)
    {
        this.returnDate = returnDate;
    }

    public String getRentDate()
    {
        return rentDate;
    }

    public void setRentDate(String rentDate)
    {
        this.rentDate = rentDate;
    }

    private String startDate;
    private String stopDate;
    private String selectedAuthor;
    private String selectedBook;

    private ArrayList<User> add1;
    public String additional1()
    {
        String idAuthor = selectedAuthor.split(" ")[1];
        try
        {
            TypedQuery<User> query = em.createQuery("SELECT distinct b.user FROM Borrow b join Catalog c on(b.catalog.id = c.id) join Book bk on(c.book.id = bk.isbn) join Author a on(bk.author.id = a.id) " +
                    "WHERE a.id= " +idAuthor  + " and (b.returnDate between '" + startDate + "'  and '" + stopDate + "')" , User.class);

            add1 = (ArrayList<User>) query.getResultList();
            return "additional1";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }

    private ArrayList<User> add2;
    public String additional2()
    {
        String idBook = selectedBook.split(" ")[1];
        try
        {
            String q = "SELECT distinct b.user FROM Borrow b join Catalog c on(b.catalog.id = c.id) join Book bk on (c.book.id = bk.isbn) where bk.id =" + idBook + " and (b" +
                    ".rentDate BETWEEN '" + startDate + "' and '" + stopDate + "' ) AND ( b.returnDate BETWEEN '" + startDate + "' and '" + stopDate + "' )";
            TypedQuery<User> query = em.createQuery(q, User.class);
            add2 = (ArrayList<User>) query.getResultList();
            return "additional2";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    private String selectedAuthor3;
    private ArrayList<Author> add3Authors;
    public String additional3()
    {
        String idAuthor = selectedAuthor3.split(" ")[1];
        try
        {
            TypedQuery<Author> query = em.createQuery("select distinct a from Borrow b join Catalog c on(b.catalog.id = c.id)" +
                    "join Book bk on (c.book.id = bk.isbn) join Author a on (bk.author.id = a.id) join User u on (b.user.id = u.id) WHERE u.id=" + idAuthor , Author.class);

            add3Authors = (ArrayList<Author>) query.getResultList();
            return "additional3";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }

    }

    private Author mostReadAuthor;
    public String additional4()
    {

        try
        {
            TypedQuery<Author> query = em.createQuery("select a from Borrow b join Catalog c on(b.catalog.id = c.id) join Book bk on (c.book.id = bk.isbn) join Author a on(bk.author.id = a.id)" +
                    "group by a.id order by count(a.id) desc", Author.class);

            mostReadAuthor = query.getResultList().get(0);
            return "additional4";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }

    }

    public Author getMostReadAuthor()
    {
        return mostReadAuthor;
    }

    public void setMostReadAuthor(Author mostReadAuthor)
    {
        this.mostReadAuthor = mostReadAuthor;
    }

    public String getSelectedAuthor3()
    {
        return selectedAuthor3;
    }

    public void setSelectedAuthor3(String selectedAuthor3)
    {
        this.selectedAuthor3 = selectedAuthor3;
    }

    public ArrayList<Author> getAdd3Authors()
    {
        return add3Authors;
    }

    public void setAdd3Authors(ArrayList<Author> add3Authors)
    {
        this.add3Authors = add3Authors;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getStopDate()
    {
        return stopDate;
    }

    public void setStopDate(String stopDate)
    {
        this.stopDate = stopDate;
    }

    public String getSelectedAuthor()
    {
        return selectedAuthor;
    }

    public void setSelectedAuthor(String selectedAuthor)
    {
        this.selectedAuthor = selectedAuthor;
    }

    public String getSelectedBook()
    {
        return selectedBook;
    }

    public void setSelectedBook(String selectedBook)
    {
        this.selectedBook = selectedBook;
    }

    public ArrayList<User> getAdd1()
    {
        return add1;
    }

    public void setAdd1(ArrayList<User> add1)
    {
        this.add1 = add1;
    }

    public ArrayList<User> getAdd2()
    {
        return add2;
    }

    public void setAdd2(ArrayList<User> add2)
    {
        this.add2 = add2;
    }
}
