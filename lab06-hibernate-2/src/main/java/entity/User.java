package entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user", schema = "soalab06")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_surname")
    private String userSurname;

    @OneToMany(mappedBy = "user")
    private List<Borrow> borrowList;

    public User()
    {
    }

    public User(String userName, String userSurname)
    {
        this.userName = userName;
        this.userSurname = userSurname;
    }

    @Override
    public String toString()
    {
        return "id: " + id + " , " + userName + " " + userSurname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserSurname()
    {
        return userSurname;
    }

    public void setUserSurname(String userSurname)
    {
        this.userSurname = userSurname;
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
