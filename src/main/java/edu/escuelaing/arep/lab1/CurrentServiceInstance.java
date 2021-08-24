/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.lab1;

/**
 *
 * @author Home
 */
public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService service;
    
    private CurrentServiceInstance(){
        service = new AlphaHttpStockService();
    }
    
    public static CurrentServiceInstance getInstance(){
        return _instance;
    }
    
    public HttpStockService getService(){
        return service;
    }
    
    public void setService(HttpStockService service){
        this.service = service;
    }
    
    
    
}
