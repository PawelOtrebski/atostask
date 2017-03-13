/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.auxilary;

import java.util.HashMap;

/**
 *
 * @author pawel
 */
public class Parser {
    
    
    private String[] legalTerms; 
    
    public Parser(){
        legalTerms = new String[]{"author","title","year","client"};
    }
    
    private String[] splitString(String term, String seperator){
        return term.split("\\s*"+seperator+"\\s*");
    }
    
    private HashMap<String,String> addTermsToMap(String[] terms){
        
        HashMap<String,String> termMap = new HashMap<>();
        String[] map = null;
        for(String t : terms){
            try{
                map = splitString(t,":");
                termMap.put(map[0], map[1]);
            }catch(Exception e){
                //not a well formed term
            }
        }
        
        return termMap;
    }
    
    private Object termToType(String key, String value) throws Exception{
        if(value==null) throw new Exception();
        
        if(key.equals("year")){
            Integer year = null;
            try{
                year = new Integer(value);
            }catch(Exception e){
                year = null;
            }
            return year;
        }else{
            return value;
        }
        
        
    }
    
    private HashMap<String,Object> getSearchTerms(HashMap<String,String> map){
        HashMap<String,Object> searchTerms = new HashMap<>();
        String value = null;
        for(String key : legalTerms){
            try{
                value = map.get(key);
                searchTerms.put(key, termToType(key,value));
                
            }catch(Exception e){/*null mapping*/}
        }
        return searchTerms;
    }
    
    public HashMap<String,Object> parseTerms(String terms){
        terms = terms.toLowerCase();
        String[] term = splitString(terms,",");
        HashMap<String,String> termMap = addTermsToMap(term);
        HashMap<String,Object> searchTerms = getSearchTerms(termMap);
       
        return searchTerms;
    }
    
    public static void main(String[] args){
        Parser p = new Parser();
        
        HashMap<String,Object> map =p.parseTerms("author :pawel  , title : mytitle, year:");
        
        for(String key: map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
    }
}
