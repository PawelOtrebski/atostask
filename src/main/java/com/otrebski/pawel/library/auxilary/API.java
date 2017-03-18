/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.auxilary;

import com.otrebski.pawel.library.db.Database;
import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.entities.Client;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pawel
 */

/*
    API for interaction with the database
*/
public class API {
    private Database db;
    
    public API(){
        this.db = Database.getInstance();
    }
    
    public void listAllBooks(){
        try{
            Collection<Book> books = db.listAllBooks();
            
            for(Book book : books){
                System.out.println(book);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listBookById(Long id){
        try{
            
            Book books = db.listBookById(id);
            System.out.println(books);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listBookByTitle(String title){
        try{
            List<Book> books = db.listBooksByTitle(title);
            
            for(Book book : books){
                System.out.println(book);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listBooksByAuthor(String author, String title){
        try{
            List<Book> books = db.listBooksByAuthorTitle(author, title);
            
            for(Book book : books){
                System.out.println(book);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listBooksByAuthorYear(String author, Integer year){
        try{
            List<Book> books = db.listBooksByAuthorYear(author, year);
            
            for(Book book : books){
                System.out.println(book);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listBooksByTitleYear(String title, Integer year){
        try{
            List<Book> books = db.listBooksByTitleYear(title, year);
            
            for(Book book : books){
                System.out.println(book);
            }
        }catch(Exception e){
            
        }
    }
    
    public void addBook(String title,  String author, Integer year){
        try{
            Book book = db.addNewBook(title, author, year);
            System.out.println(book+": added to library");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void addClient(String name){
        try{
            Client client = db.addNewClient(name);
            System.out.println(client+": added to list");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void lendBook(Long bookId,String client){
        try{
            Book b = db.lendBook(bookId, client);
            System.out.println(b.getTitle()+" lent to "+b.getClient().getName());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void returnBook(Long bookId,String client){
        try {
            Book b = db.returnBook(bookId, client);
            System.out.println("book "+b.getTitle()+" returned");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void removeBook(Long bookId){
        try{
            Book book = db.deleteBook(bookId);
            System.out.println(book+"\n: deleted");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
