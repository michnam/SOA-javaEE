package pl.michnamarcin.entity;

import java.io.Serializable;

public class Movie implements Serializable
{
    private int id;
    private int title;
    private String uri;

    public Movie()
    {
    }

    public Movie(int title, String uri)
    {
        this.title = title;
        this.uri = uri;
    }

    @Override
    public String toString()
    {
        return "Movie{" +
                "id=" + id +
                ", title=" + title +
                ", uri='" + uri + '\'' +
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

    public int getTitle()
    {
        return title;
    }

    public void setTitle(int title)
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
}
