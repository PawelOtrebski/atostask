
package com.otrebski.pawel.library.main;


import com.otrebski.pawel.library.db.Database;
import com.otrebski.pawel.library.exceptions.AuthorExistsException;

/**
 *
 * @author pawel
 */
public class Main {
    
    public static void main(String args[]){
       Database db = Database.getInstance();
       db.addNewBook("one", "pawel otrebski", 2001);
       db.addNewBook("two", "pawel otrebski", 2003);
       db.addNewBook("three", "krzys otrebski", 2002);
       
       db.addNewClient("marta nowakowska");
       db.addNewClient("alina frydlewicz");
       
       db.lendBook(1L, "alina frydlewicz");
       db.lendBook(1L, "marta nowakowska");
       db.lendBook(0L, "john wayne");
       db.lendBook(2L, "john wayne");
       
       db.listAllBooks();
    }
}
