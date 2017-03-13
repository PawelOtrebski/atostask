
package com.otrebski.pawel.library.interfaces;

/**
 *
 * @author pawel
 */
public abstract class Person {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    protected String name;
    protected Long id;
    
    public Person(){
        this.name = null;
        this.id = null;
    }
    
    public Person(String name){
        this.name = name;
        this.id = null;
    }
}
