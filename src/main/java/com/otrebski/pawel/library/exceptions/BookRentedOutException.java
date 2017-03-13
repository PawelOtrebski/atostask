/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.exceptions;

import com.otrebski.pawel.library.entities.Book;

/**
 *
 * @author pawel
 */
public class BookRentedOutException extends Exception{
    
    protected String message;
    
    public BookRentedOutException(String message){
        super(message);
    }
    
    public BookRentedOutException(Book book){
        super();
        String format = "Book with id: %d, title: %s rented out to: %s (id: %d)";
        this.message = String.format(format, book.getId(),book.getTitle(),
                book.getClient().getName(),book.getClient().getId());
    }
}
