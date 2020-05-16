package pl.michnamarcin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "movie", schema = "soalab08")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String uri;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Movie()
    {
    }

    public Movie(String title, String uri, User user)
    {
        this.title = title;
        this.uri = uri;
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
