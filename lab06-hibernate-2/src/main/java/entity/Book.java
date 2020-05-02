package entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book", schema = "soalab06")
public class Book
{
    @Id
    private String isbn;

    private String title;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Catalog> catalogList;

    public Book()
    {
    }

    public Book(String isbn, String title, Author author, Category category)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Isbn: " + isbn + " Title: " + title + ", by " + author + ", " + category.getCategoryName();
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<Catalog> getCatalogList()
    {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList)
    {
        this.catalogList = catalogList;
    }
}
