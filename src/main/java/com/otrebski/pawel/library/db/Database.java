
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
    
    public void addNewBook(String title, String author, Integer year){
        Author a = this.getAuthorsRepository().findOrCreate(author);
        this.getBookRepository().create(title, a, year);
    }
    
    /*
        Creates a new client with a given name and adds the client to 
        the database. Throws an exception if the client exists or when the name
        is a null value
    */
    
    public void addNewClient(String name){
        try{
            Client c = this.getClientsRepository().create(name);
        }catch(NullPointerException | ClientExistsException ne){
            System.out.println(ne.getMessage());
        }
        
    }
    
    /*
        Lends a book with bookId to client withe given name.
        
        A book cannot be rented out if it is already rented out or 
        if the client with a given name does not exist
    */
    
    public void lendBook(Long bookId,String name){
        try{
            Book book = this.getBookRepository().findById(bookId);
            Client client = this.getClientsRepository().findByName(name);
            
            if(book.getCurrentStatus().equals(Status.OUT))
                throw new BookRentedOutException(book);
            
            book.setCurrentStatus(Status.OUT);
            book.setClient(client);
            
            client.addToRented(book);
            
            this.getBookRepository().update(bookId, book);
            this.getClientsRepository().update(name, client);
            
        }catch(BookNotFoundException |ClientNotFoundException |
                BookRentedOutException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        Deletes the book from the database provided that the book exists
        and that some client has not rented the book out
    */
    public void deleteBook(Long bookId){
        try{
            
            this.getBookRepository().delete(bookId);
            
        }catch(BookNotFoundException | BookRentedOutException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        Client returns the book they have rented out
        Client cannot return a book client didn't rent out 
        and cannot return a book that doesn't exist
    */
    
    public void returnBook(Long id, String name){
        try{
            
            Book book = this.getBookRepository().findById(id);
           
            Client client = this.getClientsRepository().findByName(name);
     
            if(!name.equals(book.getClient().getName()))
                throw new BookRentedOutException(book);
            
            client.removeFromRented(book);
            book.setCurrentStatus(Status.IN);
            book.setClient(null);
            
            this.getBookRepository().update(id, book);
            this.getClientsRepository().update(name, client);
            
        }catch(BookNotFoundException | BookRentedOutException | ClientNotFoundException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        List all books in the database distinctly. Information includes 
        title, author, year, availability and client renting (if exists).
    
        Additional information includes the number of books in the database as 
        well as sundry information such as books rented out and books available
    */
   
    public void listAllBooks(){
        Collection<Book> books = this.getBookRepository().findAll();
        
        for(Book book : books){
            System.out.println(book+"\n");
        }
        
        System.out.println("\n\n"+this.getBookRepository().getAllStats());
    }
    
    /*
        List a given book by id. Information includes:
        title, author, year, availability and client renting (if OUT)
    */
    
    public void listBookById(Long bookId){
        try{
            Book book = this.getBookRepository().findById(bookId);
            
            System.out.println(book);
        }catch(BookNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        List books by title, many books have the same title but different 
        authors and different years of publishing
    */
    
    public void listBooksByTitle(String title){
        try{
            
            List<Book> books = this.getBookRepository().findByName(title);
            
            for(Book book : books){
                System.out.println(book+"\n");
            }
            
        }catch(BookNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        List books by author and year of publishing. 
    */
    
    public void listBooksByAuthorYear(String name, Integer year){
        try{
            
            Author author = this.getAuthorsRepository().find(name);
            List<Book> list = this.getBookRepository().findByAuthor(author);
            
            List<Book> titles = new ArrayList<>();
            
            for(Book book : list){
                if(book.getYear().equals(year)){
                    titles.add(book);
                }
            }
            
            for(Book book : titles){
                System.out.println(book);
            }
            
        }catch(BookNotFoundException | NullPointerException | 
                AuthorNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        List books by author and title
    */
    
    public void listBooksByAuthorTitle(String name,String title){
        try{
            
            Author author = this.getAuthorsRepository().find(name);
            List<Book> list = this.getBookRepository().findByAuthor(author);
            
            List<Book> titles = new ArrayList<>();
            
            for(Book book : list){
                if(book.getTitle().equals(title)){
                    titles.add(book);
                }
            }
            
            for(Book book : titles){
                System.out.println(book);
            }
            
        }catch(AuthorNotFoundException | NullPointerException |
                BookNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    /*
        List books by title and year of publishing
    */
    
    public void listBooksByTitleYear(String title, int year){
        try{
            
            List<Book> list = this.getBookRepository().findByName(title);
            
            List<Book> titles = new ArrayList<>();
            
            for(Book book : list){
                if(book.getYear().equals(year)){
                    titles.add(book);
                }
            }
            
            for(Book book : titles){
                System.out.println(book);
            }
            
        }catch(BookNotFoundException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listAllClients(){
        try{
            Collection<Client> clients = this.getClientsRepository().find();
            
            for(Client client : clients){
                System.out.println(client);
                System.out.println("Titles rented:");
                for(Book book : client.getRented().values()){
                    System.out.println(book.getTitle());
                }
            }
            
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listClientByName(String name){
        try{
            
            Client client = this.getClientsRepository().findByName(name);
            
            System.out.println(client);
            System.out.println("Titles rented:");
            for(Book book : client.getRented().values()){
                System.out.println(book.getTitle());
            }
            
        }catch(ClientNotFoundException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the bookRepository
     */
    public BooksRepo getBookRepository() {
        return bookRepository;
    }

    /**
     * @return the clientsRepository
     */
    public ClientRepo getClientsRepository() {
        return clientsRepository;
    }

    /**
     * @return the authorsRepository
     */
    public AuthorRepo getAuthorsRepository() {
        return authorsRepository;
    }
    
    public static void main(String args[]){
        
    }
}
