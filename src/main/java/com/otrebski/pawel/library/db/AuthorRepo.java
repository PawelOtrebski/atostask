
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.exceptions.AuthorExistsException;
import com.otrebski.pawel.library.exceptions.AuthorNotFoundException;
import com.otrebski.pawel.library.factories.AuthorFactory;
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
    
    public Author create(Author author)
            throws AuthorExistsException,NullPointerException{
        
        
        if(authors.containsKey((String)author.getId())) throw new AuthorExistsException((String)author.getId());
        this.authors.put(author.getId(), author);
        return author;
    }
    
    /*
        More commonly used method.
        finds an author with a given name if such an author exists or 
        creates a new author 
    */
    public Author findOrCreate(String name) throws Exception{
        
        
        Author author = null;
        if(name == null) throw new NullPointerException("name cannot be null");
        
        try{
            author = AuthorFactory.produceAuthor();
            author.setId(name);
            author.setName(name);
            
            author = this.create(author);
        }catch(AuthorExistsException e){
            author = this.find(name);
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
        
        if(!authors.containsKey(name)) throw new AuthorNotFoundException(name);
        
        return authors.get(name);
    }
    
    public Author updated(String authorId,Author author) throws Exception{
        if(!this.authors.containsKey(authorId))
            throw new AuthorNotFoundException(authorId);
        Author persisted = this.authors.replace(authorId, author);
        return persisted;
    }
    
    public Author delete(String authorId) throws Exception{
        if(!this.authors.containsKey(authorId))
            throw new AuthorNotFoundException(authorId);
        return this.authors.remove(authorId);
    }
    
    
    
    public static void main(String[]args){
       
       
    }
    
    
}
