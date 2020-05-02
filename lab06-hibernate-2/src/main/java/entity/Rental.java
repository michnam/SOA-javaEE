package entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "rental", schema = "soalab06")
public class Rental
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_catalog")
    private Catalog catalog;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "rent_date")
    private Date rentDate;

    @Column(name = "return_date")
    private Date returnDate;

    public Rental()
    {
    }

    public Rental(int id, Catalog catalog, User user, Date rentDate, Date returnDate)
    {
        this.id = id;
        this.catalog = catalog;
        this.user = user;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString()
    {
        return "Rental{" +
                "id=" + id +
                ", catalog=" + catalog +
                ", user=" + user +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public Catalog getCatalog()
    {
        return catalog;
    }

    public void setCatalog(Catalog catalog)
    {
        this.catalog = catalog;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getRentDate()
    {
        return rentDate;
    }

    public void setRentDate(Date rentDate)
    {
        this.rentDate = rentDate;
    }

    public Date getReturnDate()
    {
        return returnDate;
    }

    public void setReturnDate(Date returnDate)
    {
        this.returnDate = returnDate;
    }
}
