/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.lab1;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Home
 */
public class Cache {
    private ConcurrentHashMap<String,String> data;
    
    public Cache(){
        data = new ConcurrentHashMap<String,String>();
    }
    
    public boolean inCache(String key){
        return data.containsKey(key);
    }
    public String getData(String key){
        return data.get(key);
    }
    public void addData(String key,String value){
        data.put(key, value);
    }
    
    
    
}
