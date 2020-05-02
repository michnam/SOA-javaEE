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

    private int condition;

    @OneToMany(mappedBy = "catalog")
    private List<Rental> rentalList;

    public Catalog()
    {
    }

    public Catalog(Book book, int condition)
    {
        this.book = book;
        this.condition = condition;
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

    public List<Rental> getRentalList()
    {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList)
    {
        this.rentalList = rentalList;
    }
}
