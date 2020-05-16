package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author", schema = "soalab06")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_surname")
    private String authorSurname;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList;

    public Author()
    {
    }

    public Author(String authorName, String authorSurname)
    {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }

    @Override
    public String toString()
    {
        return "id: " + id + " , " + authorName + " " + authorSurname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public String getAuthorSurname()
    {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname)
    {
        this.authorSurname = authorSurname;
    }

    public List<Book> getBookList()
    {
        return bookList;
    }

    public void setBookList(List<Book> bookList)
    {
        this.bookList = bookList;
    }
}
