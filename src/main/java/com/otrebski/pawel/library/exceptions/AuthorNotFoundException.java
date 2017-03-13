
package com.otrebski.pawel.library.exceptions;

/**
 *
 * @author pawel
 */
public class AuthorNotFoundException extends Exception{
    
    private String message;
    public AuthorNotFoundException(String message){
        super();
        String format = "Author: %s does not exist";
        this.message = String.format(format, message);
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
