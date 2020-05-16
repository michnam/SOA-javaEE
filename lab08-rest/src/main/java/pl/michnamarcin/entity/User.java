package pl.michnamarcin.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user", schema = "soalab08")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private int age;

    @Lob
    private byte[] avatar;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval=true)
    private List<Movie> movies;

    public User()
    {
    }

    public User(String username, int age, byte[] avatar)
    {
        this.username = username;
        this.age = age;
        this.avatar = avatar;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", avatar=" + Arrays.toString(avatar) +
                ", movies=" + movies +
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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public byte[] getAvatar()
    {
        return avatar;
    }

    public void setAvatar(byte[] avatar)
    {
        this.avatar = avatar;
    }

    public List<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(List<Movie> movies)
    {
        this.movies = movies;
    }
}
