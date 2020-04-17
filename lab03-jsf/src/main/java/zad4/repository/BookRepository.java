package zad4.repository;

import zad4.entity.Book;

import java.util.ArrayList;

public class BookRepository
{
    private static ArrayList<Book> books = new ArrayList<Book>()
    {
        {
            add(new Book(1, "It's Not Easy Being a Bunny", "Marilyn Sadler", "children", 7.29, "EUR", 123));
            add(new Book(2, "American Dirt", "Jeanine Cummins", "novel", 8.59, "USD", 387));
            add(new Book(3, "When We Believed in Mermaids", "Barbara O'Neal", "novel", 66.66, "PLN", 666));
            add(new Book(4, "Automate the Boring Stuff with Python", "Al Sweigart", "IT", 40.99, "PLN", 456));
            add(new Book(5, "Web Design with HTML, CSS", "Jon Duckett", "IT", 14.99, "USD", 262));
        }
    };

    public static ArrayList<Book> getBooks()
    {
        return books;
    }
}
