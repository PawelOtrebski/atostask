/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.factories;

import com.otrebski.pawel.library.entities.Book;

/**
 *
 * @author pawel
 */
public class BookFactory {
    
    private static Long numberCreated = 0L;
    
    private BookFactory() {
        
    }
    
    public static BookFactory getInstance() {
        return BookFactoryHolder.INSTANCE;
    }
    
    private static class BookFactoryHolder {

        private static final BookFactory INSTANCE = new BookFactory();
    }
    
    public static Book produceBook(){
        Book book = new Book();
        book.setId(++numberCreated);
        return book;
    }
}
