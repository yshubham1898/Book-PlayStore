package controllers;

import model.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;


import views.html.books.create;
import views.html.books.edit;

import javax.inject.Inject;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class BooksController extends Controller {

    @Inject
    FormFactory formFactory;



    // to get list of books
    public Result getAll(){
        List<Book> books = Book.allBooks();
        return ok(views.html.books.index.render((ArrayList<Book>) books));
    }


    //create a new book
    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(views.html.books.create.render(bookForm));
    }


    //doubt ============================================================================================================================
    //save a book
//    public Result save(){
//        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
//        Book book = bookForm.get();
//        //saving the book in temporary storage
//        Book.add(book);
//        return redirect(routes.BooksController.getAll());
//    }
    //===================================================================================================================================


    //edit a book
    public Result edit(Integer id){
        Book book = Book.findById(id);
        //check whether book is present or not
        if(book == null){
            return notFound("Book not found!!!");
        }
        //fill() method will take the book object, and put it into form
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }

    //doubt ===========================================================================================================================

    //update a book
//    public Result update(){
//        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
//        Book book = bookForm.get();
//
//        //get old book we want to update
//        Book oldBook = Book.findById(book.id);
//        if(oldBook == null){
//            return notFound("Book not found!!");
//        }
//        //update a book
//        oldBook.title = book.title;
//        oldBook.author = book.author;
//        oldBook.price = book.price;
//
//        return redirect(routes.BooksController.getAll());
//    }

    //==========================================================================================================================================

    //show a particular book information when clicked on it
    public Result show(Integer id){
        Book book = Book.findById(id);
        if(book == null){
            return notFound("Book not found!!!");
        }
        return ok(views.html.books.show.render(book));
    }


    //delete a book
    public Result delete(Integer id){
        Book book = Book.findById(id);

        if(book == null){
            return notFound("Book not found!!!");
        }

        //will remove/delete the book
        Book.remove(book);
        return redirect(routes.BooksController.getAll());
    }
}
