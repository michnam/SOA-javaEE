package model;

public class Seat
{
    private int id;
    private String name;
    private int price;
    private boolean booked;

    public Seat(int id, String name, int price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.booked = false;
    }

    @Override
    public String toString()
    {
        return "id: " + id + ", name: " + name + ", price: " + price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public boolean isBooked()
    {
        return booked;
    }

    public void setBooked(boolean booked)
    {
        this.booked = booked;
    }
}
