/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.exceptions;

/**
 *
 * @author pawel
 */
public class ClientNotFoundException extends Exception{
   
    public ClientNotFoundException(String message){
        super(message);
    }
}
