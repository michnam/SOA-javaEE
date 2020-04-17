package zad4.entity;

import zad4.util.CurrencyExchanger;

public class Book
{
    private int id;
    private String title;
    private String author;
    private String category;
    private double price;
    private String currency;
    private int pages;

    public Book(int id, String title, String author, String category, double price, String currency, int pages)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.currency = currency;
        this.pages = pages;
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

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public int getPages()
    {
        return pages;
    }

    public void setPages(int pages)
    {
        this.pages = pages;
    }

    public double getPricePLN()
    {
        return CurrencyExchanger.changeToPLN(currency, price);
    }
}
