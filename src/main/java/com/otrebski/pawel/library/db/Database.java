
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.entities.Client;
import com.otrebski.pawel.library.enums.Status;
import com.otrebski.pawel.library.exceptions.AuthorNotFoundException;
import com.otrebski.pawel.library.exceptions.BookNotFoundException;
import com.otrebski.pawel.library.exceptions.BookRentedOutException;
import com.otrebski.pawel.library.exceptions.ClientExistsException;
import com.otrebski.pawel.library.exceptions.ClientNotFoundException;
import com.otrebski.pawel.library.factories.AuthorFactory;
import com.otrebski.pawel.library.factories.BookFactory;
import com.otrebski.pawel.library.factories.ClientFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author pawel
 */

/**
 * 
 *  Class Database represents the library as a whole product. 
 *  The Library consists of three "repositories":clients,authors and books.
 * 
 *  The repositories are responsible for the main CRUD operations. 
 * 
 *  All operations to access the database are interfaced by methods that then 
 *  use methods that are specific to a repository
 * 
 *  This class catches all exceptions on the fly and does not propagate them futher
 *  only printing to standard output the results of the operation
 */
public class Database {
    
    /**
     * The repositories for each entity 
     */
    
    private BooksRepo bookRepository;
    private ClientRepo clientsRepository;
    private AuthorRepo authorsRepository;
    
    private ClientFactory clientFactory;
    
    private Database(){
        
        this.bookRepository = new BooksRepo();
        this.clientsRepository = new ClientRepo();
        this.authorsRepository = new AuthorRepo();
    }
    
    /*
        Hack off template for Singleton in Netbeans
    */
    public static Database getInstance(){
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder{
        private static final Database INSTANCE = new Database();
    }
    
    /*
        Add a new book to the collection of books. The author is found 
        or created and then added to the books author field.
    */
    
    public Book addNewBook(String title, String author, Integer year) throws Exception{
            Book b = BookFactory.produceBook();
            Author a = this.authorsRepository.findOrCreate(author);
            b.setAuthor(a);
            b.setTitle(title);
            b.setYear(year);
            
            b = this.bookRepository.create(b);
            
            return b;
            
    }
    
    /*
        Creates a new client with a given name and adds the client to 
        the database. Throws an exception if the client exists or when the name
        is a null value
    */
    
    public Client addNewClient(String name) throws Exception {
        Client c = ClientFactory.produceClient();
        c.setName(name);
        this.clientsRepository.create(c);
        return c;
        
    }
    
    /*
        Lends a book with bookId to client withe given name.
        
        A book cannot be rented out if it is already rented out or 
        if the client with a given name does not exist
    */
    
    public Book lendBook(Long bookId,String name) throws Exception{
        
            Book book = this.bookRepository.findById(bookId);
            Client client = this.clientsRepository.findByName(name);
            
            if(book.getCurrentStatus().equals(Status.OUT))
                throw new BookRentedOutException(book);
            
            book.setCurrentStatus(Status.OUT);
            book.setClient(client);
            
            client.addToRented(book);
            
            this.bookRepository.update(bookId, book);
            this.clientsRepository.update(name, client);
            
            return book;
    }
    
    /*
        Deletes the book from the database provided that the book exists
        and that some client has not rented the book out
    */
    public Book deleteBook(Long bookId) throws Exception{
        Book book = this.bookRepository.findById(bookId);
        return this.bookRepository.delete(bookId);
    }
    
    /*
        Client returns the book they have rented out
        Client cannot return a book client didn't rent out 
        and cannot return a book that doesn't exist
    */
    
    public Book returnBook(Long id, String name) throws Exception{
       
            
            Book book = this.bookRepository.findById(id);
           
            Client client = this.clientsRepository.findByName(name);
     
            if(!name.equals(book.getClient().getName()))
                throw new BookRentedOutException(book);
            
            client.removeFromRented(book);
            book.setCurrentStatus(Status.IN);
            book.setClient(null);
            
            this.bookRepository.update(id, book);
            this.clientsRepository.update(name, client);
            
            return book;
        
    }
    
    /*
        List all books in the database distinctly. Information includes 
        title, author, year, availability and client renting (if exists).
    
        Additional information includes the number of books in the database as 
        well as sundry information such as books rented out and books available
    */
   
    public Collection<Book> listAllBooks() throws Exception{
        Collection<Book> books = this.bookRepository.findAll();
        
        return books;
    }
   
    /*
        List a given book by id. Information includes:
        title, author, year, availability and client renting (if OUT)
    */
    
    public Book listBookById(Long bookId) throws Exception{
            Book book = this.bookRepository.findById(bookId);
            
            System.out.println(book);
            
            return book;
            
    }
    
    /*
        List books by title, many books have the same title but different 
        authors and different years of publishing
    */
    
    public List<Book> listBooksByTitle(String title) throws Exception{   
        List<Book> books = this.bookRepository.findByName(title);
            
        return books;
    }
    
    /*
        List books by author and year of publishing. 
    */
    
    public List<Book> listBooksByAuthorYear(String name, Integer year) throws Exception{
        
            Author author = this.authorsRepository.findOrCreate(name);
            List<Book> list = this.bookRepository.findByAuthor(author);
            
            List<Book> titles = new ArrayList<>();
            
            for(Book book : list){
                if(book.getYear().equals(year)){
                    titles.add(book);
                }
            }
            
            
            return list;
    }
    
    /*
        List books by author and title
    */
    
    public List<Book> listBooksByAuthorTitle(String name,String title) throws Exception{
       
            
            Author author = this.authorsRepository.find(name);
            List<Book> list = this.bookRepository.findByAuthor(author);
            
            List<Book> titles = new ArrayList<>();
            
            for(Book book : list){
                if(book.getTitle().equals(title)){
                    titles.add(book);
                }
            }
            
        
            return titles;
    
    }
    
    /*
        List books by title and year of publishing
    */
    
    public List<Book> listBooksByTitleYear(String title, int year) throws Exception{
        
            
        List<Book> list = this.bookRepository.findByName(title);
            
        return list;
    }
    
    public Collection<Client> listAllClients() throws Exception{
       
        Collection<Client> clients = this.clientsRepository.find();
            
            
        return clients; 
    }
    
    public Client listClientByName(String name) throws Exception{
        
            
        Client client = this.clientsRepository.findByName(name);
            
            
        return client;  
        
    }
    
    public static void main(String[]args) throws Exception{
        Database db = Database.getInstance();
        
        db.addNewBook("test", "pawel", 2001);
        db.addNewBook("test2", "pawel", 2002);
        db.addNewBook("another test", "krzys", 2009);
        db.addNewBook("test three", "wojciech", 2001);
        
        db.addNewClient("giles smith");
        db.addNewClient("peter green");
        db.addNewClient("moses mary");
        db.addNewClient("justin timberman");
        
        db.lendBook(1L, "peter green");
        db.lendBook(2L, "peter green");
        db.lendBook(3L, "justin timberman");
        
        db.returnBook(3L, "justin timberman");
        
        try{
            db.lendBook(1L, "moses mary");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
  
}
