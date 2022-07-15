package model;

import com.avaje.ebean.Model;


import java.util.ArrayList;
import java.util.List;

public class Book implements Model {

    public Integer id;
    public String title;
    public Integer price;
    public String author;

    public Book(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public Book() {
    }

    private static java.util.List<Book> books;

    static {
        books = new ArrayList<>();
        books.add(new Book(1,"Java",250,"L Henry"));
        books.add(new Book(2,"Basics of Computer Science",550,"K Williams"));
        books.add(new Book(3,"Guide to Zero",95,"H George"));

    }


    //method will return all books
   public static List<Book> allBooks(){
        return books;
   }

    //method to find a single book
    public static Book findById(Integer id){
        for(Book book : books){
            if(id.equals(book.id)){
                return book;
            }
        }
        return null;
    }

    //method to add a book
    public static void add(Book book){
        books.add(book);
    }

    //method to delete book
    public static boolean remove(Book book){
        return books.remove(book);
    }



}
