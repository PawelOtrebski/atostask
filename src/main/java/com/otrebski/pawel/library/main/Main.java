
package com.otrebski.pawel.library.main;

import com.otrebski.pawel.library.auxilary.API;
import com.otrebski.pawel.library.db.Database;



/**
 *
 * @author pawel
 */

/*
    Example run for the database
*/
public class Main {
    /*
        A session using the api to access the library 
    */
    public static void main(String[]args){
       API api = new API();
       
       //add some books
       api.addBook("book one", "author one", 2001);
       api.addBook("book two", "author two", 2001);
       api.addBook("book three", "author three", 2002);
       api.listAllBooks();
       
       //add some clients
       api.addClient("client one");
       api.addClient("client two");
       api.addClient("client three");
       
       //lend books to clients 
       api.lendBook(1L, "client two");
       api.lendBook(2L, "client two");
       api.lendBook(1L,"client one");
       api.lendBook(3L, "client three");
       
       //client returns book
       api.returnBook(1L, "client two");
       api.returnBook(2L, "client two");
       //list books by id
       api.listBookById(1L);
       api.listBookById(2L);
       
       //delete book
       api.removeBook(1L);
       api.removeBook(3L);
    }

}
