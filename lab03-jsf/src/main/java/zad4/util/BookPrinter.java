package zad4.util;

import zad4.entity.Book;

public class BookPrinter
{
    private Book book;
    private String prettyPrice;
    private boolean selected;

    public BookPrinter(Book book)
    {
        this.book = book;

        this.selected = false;

        if(book.getCurrency().equals("PLN")) this.prettyPrice = book.getPrice() + " zł";
        else if(book.getCurrency().equals("USD")) this.prettyPrice = book.getPrice() + " $";
        else this.prettyPrice = book.getPrice() + " €";
    }

    public void setPrettyPricePLN()
    {
        this.prettyPrice = CurrencyExchanger.changeToPLN(book.getCurrency(),book.getPrice()) + " zł";
    }

    public String getTitle()
    {
        return book.getTitle();
    }

    public String getAuthor()
    {
        return book.getAuthor();
    }

    public String getCategory() { return book.getCategory(); }

    public int getPages()
    {
        return book.getPages();
    }

    public void setSelected(boolean isSelected)
    {
        this.selected = isSelected;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public String getPrettyPrice()
    {
        return prettyPrice;
    }

    public void setPrettyPrice(String prettyPrice)
    {
        this.prettyPrice = prettyPrice;
    }
}
