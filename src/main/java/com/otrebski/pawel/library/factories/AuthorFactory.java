/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.factories;

import com.otrebski.pawel.library.entities.Author;

/**
 *
 * @author pawel
 */
public class AuthorFactory {
    private static Long numberCreated = 0L;
    private AuthorFactory() {
        
    }
    
    public static AuthorFactory getInstance() {
        return AuthorFactoryHolder.INSTANCE;
    }
    
    private static class AuthorFactoryHolder {

        private static final AuthorFactory INSTANCE = new AuthorFactory();
    }
    
    public static Author produceAuthor(){
        Author author = new Author();
        
        return author;
    }
}
