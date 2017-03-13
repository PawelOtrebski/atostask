package com.otrebski.pawel.library.entities;

import com.otrebski.pawel.library.enums.Status;
import com.otrebski.pawel.library.interfaces.EntityInterface;



/**
 *
 * @author pawel
 */
public class Book implements EntityInterface {

    
    
    private Long id;
    private String title;
    private Author author;
    private Integer year;
    private Status currentStatus;
    private Client client;
    
    public Book(){
        this.id = null;
        this.title = null;
        this.author = null;
        this.year = null;
        this.client = null;
        this.currentStatus = Status.IN;
    }
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public Author getAuthors() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public void setYear(Integer year){
        this.year = year;
    }
    
    
    public Integer getYear(){
        return this.year;
    }

    /**
     * @return the currentStatus
     */
    public Status getCurrentStatus() {
        return currentStatus;
    }

    /**
     * @param currentStatus the currentStatus to set
     */
    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
    
    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
    
    @Override
    public String toString(){
        String clientString = null;
        
        if(client==null){
            clientString = "None";
        }else{
            clientString = client.toString();
        }
        
        String format = "id: %s\ntitle: %s\nyear: %d\nauthor:\n %s\n\bstate: "+
                "%s\nclient: \n\b\t%s";
        
        return String.format(format,this.id,this.title,this.year
                ,this.author,this.currentStatus,clientString);
    }

    public boolean equals(Object o){
        return false;
    }
   
}
