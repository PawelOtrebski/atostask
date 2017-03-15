
package com.otrebski.pawel.library.main;


import com.otrebski.pawel.library.db.Database;

/**
 *
 * @author pawel
 */

/*
    A main class that just shows how to use the database
*/
public class Main {
    
    public static void printLine(String title){
        System.out.println("######## "+title+"########");
    }
    
    public static void printLine(){
        System.out.println("###########################");
    }
    
    public static void addClients(Database db){
        printLine("ADDING NEW USERS");
        db.addNewClient("john wayne");
        db.addNewClient("chris rock");
        db.addNewClient("kiera knightly");
        db.addNewClient("pamela anderson");
        db.addNewClient("lucy liu");
        db.addNewClient("tyrese gibson");
        db.addNewClient("charlize theron");
        printLine("CURRENT USERS");
        db.listAllClients();
    }
    
    public static void addDuplicateClients(Database db){
        printLine("ADDING ERROR GENERATING USERS");
        db.addNewClient("john wayne");
        db.addNewClient("charlize theron");
        db.addNewClient("kiera knightly");
        db.addNewClient(null);
        printLine("CURRENT USERS");
        db.listAllClients();
    }
    
    public static void addBooks(Database db){
        printLine("ADDING BOOKS");
        db.addNewBook("the art of computer programming vol 1",
                "donald knuth", 1981);
        db.addNewBook("the art of computer programming vol 2",
                "donald knuth", 1982);
        db.addNewBook("the art of computer programming vol 3", 
                "donald knuth", 1983);
        db.addNewBook("introduction to algorithms", "thomas cormen", 2014);
        db.addNewBook("syntactic structures", "noam chomsky", 1955);
        db.addNewBook("data mining", "jeff ullman", 2001);
        db.addNewBook("automata theory","jeff ullman",1979);
        db.addNewBook("ansi c","dennis ritchie",1977);
        db.addNewBook("communicating sequential processes","tony hoare",1980);
        db.addNewBook("the art of computer programming vol 1",
                "donald knuth", 1981);
        db.addNewBook("the art of computer programming vol 1",
                "donald knuth", 1981);
        db.addNewBook("introduction to algorithms", "thomas cormen", 2014);
        db.addNewBook("introduction to algorithms", "thomas cormen", 2014);
        db.addNewBook("introduction to algorithms", "thomas cormen", 2014);
        printLine("CURRENT BOOKS IN LIBRARY");
        db.listAllBooks();
        
    }
    
    public static void lendBooks(Database db){
        printLine("LEND BOOKS TO CLIENTS");
        db.lendBook(1L, "john wayne");
        db.lendBook(2L, "kiera knightly");
        db.lendBook(3L,"john wayne");
        db.lendBook(14L,"charlize theron");
        db.lendBook(13L, "tyrese gibson");
        db.lendBook(6L,"lucy liu");
        db.lendBook(7L, "john wayne");
        db.lendBook(8L, "pamela andersion");
        printLine("CURRENT BOOKS IN LIBRARY");
    }
    
    public static void lendDuplicate(Database db){
        printLine("ATTEMPT TO LEND BOOK THAT IS OUT");
        db.lendBook(2L, "chris rock");
        db.lendBook(14L, "lucy liu");
        db.lendBook(7L, "tyrese gibson");
        db.lendBook(6L, "kiera knightly");
        printLine("CURRENT BOOKS IN LIBRARY");
        db.listAllBooks();
    }
    
    public static void clientReturns(Database db){
        printLine("CLIENT RETURNS BOOK");
        db.returnBook(2L, "kiera knightly");
        db.returnBook(7L, "john wayne");
        db.returnBook(6L, "lucy liu");
        printLine("CURRENT BOOKS IN LIBRARY");
        db.listAllBooks();
    }
    
    public static void deleteBooks(Database db){
        printLine("DELETING 4 BOOKS THAT ARE NOT RENTED AND EXIST");
        db.deleteBook(5L);
        db.deleteBook(7L);
        db.deleteBook(9L);
        db.deleteBook(10L);
        printLine("CURRENT BOOKS IN LIBRARY");
        db.listAllBooks();
        
    }
    
    public static void deleteOutBooks(Database db) {
        printLine("DELETE BOOKS THAT ARE OUT");
        db.deleteBook(1L);
        db.deleteBook(2L);
        db.deleteBook(14L);
        printLine("CURRENT BOOKS IN LIBRARY");
        db.listAllBooks();
        
    }
    
    public static void listAllClients(Database db){
        printLine("LIST ALL CLIENTS");
        db.listAllClients();
    }
    
    public static void main(String args[]){
       Database db = Database.getInstance();
       
       addClients(db);
       addDuplicateClients(db);
       addBooks(db);
       lendBooks(db);
       lendDuplicate(db);
       clientReturns(db);
       deleteBooks(db);
       lendDuplicate(db);
       deleteOutBooks(db);
       listAllClients(db);
    }

    
}
