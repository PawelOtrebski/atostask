/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.factories;

import com.otrebski.pawel.library.entities.Client;

/**
 *
 * @author pawel
 */
public class ClientFactory {
    private static Long  numberCreated = 0L;
    private ClientFactory() {
        
    }
    
    public static ClientFactory getInstance() {
        return ClientFactoryHolder.INSTANCE;
    }
    
    private static class ClientFactoryHolder {

        private static final ClientFactory INSTANCE = new ClientFactory();
    }
    
    
    
    public static Client produceClient(){
        Client client = new Client();
        
        return client;
    }
}
