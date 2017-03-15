
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.exceptions.AuthorExistsException;
import com.otrebski.pawel.library.exceptions.AuthorNotFoundException;
import java.util.HashMap;

/**
 *
 * @author pawel
 */

/*
    Repository for all the authors that were created in the database.   
    
*/
public class AuthorRepo {
    /*
        Keep track of the number of authors created, used for ID generation
    */
    private long numberCreated;
    private HashMap<String,Author> authors;
    
    public AuthorRepo(){
        this.authors = new HashMap<>();
        numberCreated = 0L;
    }
    
    /*
        generate an id for a new Author that is created
    */
    public Long generateId(){
        return ++numberCreated;
    }
    
    /*
        Create a new author if the author does not exist.
        This is a simplified model that assumes that an authors 
        name is unique, that is no two John Smith's exist.
    
        if an author with a given name exists then an existing author 
        exception is thrown
    */
    
    public Author create(String name)
            throws AuthorExistsException,NullPointerException{
        
        name = name.replaceAll("\\s+", " ").trim().toLowerCase();
        
        if(authors.containsKey(name)) throw new AuthorExistsException(name);
        
        
        
        Author author = new Author();
        author.setName(name);
        author.setId(this.generateId());
        
        this.authors.put(name, author);
        return author;
    }
    
    /*
        More commonly used method.
        finds an author with a given name if such an author exists or 
        creates a new author 
    */
    public Author findOrCreate(String name) throws NullPointerException{
        
        Author author = null;
        name = name.replaceAll("\\s+", " ").trim().toLowerCase();
       
        if(name == null) throw new NullPointerException("name cannot be null");
        
        if(authors.containsKey(name)){
            author = authors.get(name);
        }else{
            author = new Author();
            author.setName(name);
            author.setId(this.generateId());
            this.authors.put(name, author);
        }
        
        return author;
    }
    /*
        Find an author with a given name or throw exceptions for null name
        value or if the author does not exist
    */
    public Author find(String name)throws NullPointerException,
            AuthorNotFoundException{
        
        if(name==null) throw new NullPointerException("name cannot be null");
        
        Author author = null;
        name = name.replaceAll("\\s+", " ").trim().toLowerCase();
        
        if(!authors.containsKey(name)) throw new AuthorNotFoundException(name);
        
        return authors.get(name);
    }
    
    public static void main(String[]args){
       
       
    }
    
    
}
