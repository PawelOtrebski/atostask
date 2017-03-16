
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.enums.Status;
import com.otrebski.pawel.library.exceptions.BookNotFoundException;
import com.otrebski.pawel.library.exceptions.BookRentedOutException;
import com.otrebski.pawel.library.interfaces.EntityInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author pawel
 */

/*
    The repository that holds all books. The storage mechanism is a simple
    java hashmap. Searching for books by Id gives us constant time access, 
    unfortunately searching for title or year, requires linear time dependent 
    on the number of keys stored in the hashmap.
*/

public class BooksRepo {
    
    /*
        Universal parameter used to keep track of the numbers created 
        Used for ID generatation
    */
    private long numberCreated;
    /*
        Storage for all the books
    */
    private HashMap<Long,Book> books;
   
   
    
    public BooksRepo(){
        books = new HashMap<>();
        this.numberCreated = 0;
    }
    
    /*
        Generate an ID 
    */
    public Long generateId(){
        return ++numberCreated;
    }
    /*
        Create a new book with a given title, author and year.
        The method throws and exception if title,yer or author is null.
    
        This acts kind of like a factory method 
    
    NOTE:
        This is a simplified model for a database as we are assuming that the 
        database contains a M:1 relationship between book and author, that is 
        many books can be written by one author, but only author can write a given
        book
    */
    public Book create(Book book) 
        throws NullPointerException{
        
        if(book == null) throw new NullPointerException("book cannot be null");
        
        books.put(book.getId(), book);
        return book;
        
    }
    
    /*
        Update the status of a given book,
        Throws an exception if the book is not in the repository
    */
    
    public Book update(Long bookId, Book book) throws BookNotFoundException{
        
        if(!books.containsKey(bookId)) throw new BookNotFoundException(bookId);
        
        
        this.books.replace(bookId, book);
        
        return book;
    }
    
    /*
        delete a book from the repository provided it is not rented out and that
        the book exists
    */
    public Book delete(Long bookId) throws BookNotFoundException,
            BookRentedOutException{
        if(!this.books.containsKey(bookId)) throw new BookNotFoundException(bookId);
        
        Book book = this.books.get(bookId);
        
        if(book.getCurrentStatus().equals(Status.OUT)) throw new BookRentedOutException(book);
        
        return this.books.remove(book.getId());
        
        
    }
    
    /*
        Find book by id
    */
    public Book findById(Long id) throws BookNotFoundException{
        if(!this.books.containsKey(id)) throw new BookNotFoundException(id);
        
        return this.books.get(id);
    }
    
    /*
        Find book by name
    */
    public List<Book> findByName(String name) throws BookNotFoundException,
            NullPointerException{
        
        ArrayList<Book> list = new ArrayList<>();
        
        for(Book book : this.books.values()){
            if(book.getTitle().equals(name)){
                list.add(book);
            }
        }
        
        if(list.isEmpty()) throw new BookNotFoundException(name);
       
        return list;
    }
    
    /*
        find book by author
    */
    public List<Book> findByAuthor(Author author) throws BookNotFoundException{
        List<Book> list = new ArrayList<>();
        
        for(Book book : books.values()){
            if(book.getAuthors().equals(author)){
                list.add(book);
            }
        }
        
        if(list.isEmpty()) throw new BookNotFoundException(author);
        
        return list;
    }
    
    /*
        Return all books from the repository as a Collection
    */
    
    public Collection<Book> findAll() throws NullPointerException{
        if(books.isEmpty()) throw new NullPointerException("Library Empty");
        return this.books.values();
    }
    
    public void setBookStatus(Long bookId,Status status) throws Exception{
        if(!books.containsKey(bookId)) throw new BookNotFoundException(bookId);
        Book b = books.get(bookId);
        if(b.getClient()!=null) throw new BookRentedOutException(b);
        b.setCurrentStatus(status);
    }
   
    public String getAllStats(){
        int numberOfBooks = this.books.size();
        int available = 0;
        int rented = 0;
        
        for(Book book : books.values()){
            if(book.getCurrentStatus().equals(Status.IN)){
                available++;
            }else{
                rented++;
            }
        }
        
        return String.format("total: %d\navailable: %d\nrented: %d",
                numberOfBooks,available,rented);
    }
    
    public static void main(String[]args){
        

    }

   
    
}
