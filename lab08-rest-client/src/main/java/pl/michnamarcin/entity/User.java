package pl.michnamarcin.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class User implements Serializable
{
    private int id;
    private String username;
    private int age;
    private byte[] avatar;
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
                ", movies=" + movies +
                '}';
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
