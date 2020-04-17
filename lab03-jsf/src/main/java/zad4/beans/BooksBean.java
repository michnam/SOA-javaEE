package zad4.beans;

import zad4.entity.Book;
import zad4.repository.BookRepository;
import zad4.util.BookPrinter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class BooksBean implements Serializable
{
    private String currencyFormValue;
    private ArrayList<String> allCategories = new ArrayList<>();
    private ArrayList<Book> allBooks = new ArrayList<>();
    private ArrayList<BookPrinter> bookPrinters = new ArrayList<>();
    private double totalPricePLN;
    private int numberSelectedBooks;

    private ArrayList<String> excludedCategories;

    //filters
    private double priceFrom;
    private double priceTo;

    private int pagesFrom;
    private int pagesTo;

    @PostConstruct
    public void init()
    {
        currencyFormValue = "original";
        allCategories.add("children");
        allCategories.add("novel");
        allCategories.add("IT");

        allBooks = BookRepository.getBooks();

        priceFrom = allBooks.get(0).getPrice();
        pagesFrom = allBooks.get(0).getPages();
        for(Book book : allBooks)
        {
            bookPrinters.add(new BookPrinter(book));
            if(priceFrom > book.getPrice()) priceFrom = book.getPrice();
            if(priceTo < book.getPrice()) priceTo = book.getPrice();

            if(pagesFrom > book.getPages()) pagesFrom = book.getPages();
            if(pagesTo < book.getPages()) pagesTo = book.getPages();
        }
    }

    public void refreshTable()
    {
        bookPrinters = new ArrayList<>();

        // filters
        boolean passesFilters = true;
        for(Book book : allBooks)
        {
            passesFilters = true;

            passesFilters = excludedCategories == null || !excludedCategories.contains(book.getCategory());

            if(currencyFormValue.equals("original"))
            {
                if(passesFilters) passesFilters = priceFrom <= book.getPrice();
                if(passesFilters) passesFilters = priceTo >= book.getPrice();
            }
            else
            {
                if(passesFilters) passesFilters = priceFrom <= book.getPricePLN();
                if(passesFilters) passesFilters = priceTo >= book.getPricePLN();
            }

            if(passesFilters) passesFilters = pagesFrom <= book.getPages();
            if(passesFilters) passesFilters = pagesTo >= book.getPages();

            if(passesFilters) bookPrinters.add(new BookPrinter(book));
        }



        // currency
        if(currencyFormValue.equals("PLN"))
            for(BookPrinter bp : bookPrinters)
                bp.setPrettyPricePLN();

    }


    // setters and getters

    public String getCurrencyFormValue()
    {
        return currencyFormValue;
    }

    public void setCurrencyFormValue(String currencyFormValue)
    {
        this.currencyFormValue = currencyFormValue;
    }

    public ArrayList<Book> getAllBooks()
    {
        return allBooks;
    }

    public ArrayList<String> getAllCategories()
    {
        return allCategories;
    }

    public ArrayList<BookPrinter> getBookPrinters()
    {
        return bookPrinters;
    }

    public void setBookPrinters(ArrayList<BookPrinter> bookPrinters)
    {
        this.bookPrinters = bookPrinters;
    }

    public double getTotalPricePLN()
    {
        totalPricePLN = 0;
        for(BookPrinter bp : bookPrinters)
            if(bp.isSelected()) totalPricePLN += bp.getBook().getPricePLN();

        totalPricePLN = Math.round(totalPricePLN * 100.0) / 100.0;
        return totalPricePLN;
    }

    public void setTotalPricePLN(double totalPricePLN)
    {
        this.totalPricePLN = totalPricePLN;
    }

    public int getNumberSelectedBooks()
    {
        numberSelectedBooks = 0;

        for(BookPrinter bp : bookPrinters)
        {
            if(bp.isSelected()) numberSelectedBooks += 1;
        }

        return numberSelectedBooks;
    }

    public void setNumberSelectedBooks(int numberSelectedBooks)
    {
        this.numberSelectedBooks = numberSelectedBooks;
    }

    public ArrayList<String> getExcludedCategories()
    {
        return excludedCategories;
    }

    public void setExcludedCategories(ArrayList<String> excludedCategories)
    {
        this.excludedCategories = excludedCategories;
    }

    public double getPriceFrom()
    {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom)
    {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo()
    {
        return priceTo;
    }

    public void setPriceTo(double priceTo)
    {
        this.priceTo = priceTo;
    }

    public int getPagesFrom()
    {
        return pagesFrom;
    }

    public void setPagesFrom(int pagesFrom)
    {
        this.pagesFrom = pagesFrom;
    }

    public int getPagesTo()
    {
        return pagesTo;
    }

    public void setPagesTo(int pagesTo)
    {
        this.pagesTo = pagesTo;
    }
}
