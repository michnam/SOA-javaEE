package entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "catalog", schema = "soalab06")
public class Catalog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    @Column(name = "book_condition")
    private int condition;

    @OneToMany(mappedBy = "catalog")
    private List<Borrow> borrowList;

    @Version
    private int version;

    public Catalog()
    {
    }

    public Catalog(Book book, int condition)
    {
        this.book = book;
        this.condition = condition;
    }

    @Override
    public String toString()
    {
        return "id: " + id + " , " + book.getTitle() + ", " + book
                .getAuthor() + ", " + book.getCategory();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public List<Borrow> getBorrowList()
    {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList)
    {
        this.borrowList = borrowList;
    }
}
