/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.lab1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static spark.Spark.*;
import spark.Request;
import spark.Response;
/**
 *
 * @author Home
 */
public class App {
    static Cache cache = new Cache();
    public static void main(String[] args){
        
        port(getPort());
        get("/facadealpha","application/json",(req,res) -> (facadeAlpha(req,res)));
        get("/facadeIex","application/json",(req,res) -> (facadeIex(req,res)));
        
        
    }
    
    
    static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
    private static String facadeIex(Request req,Response res){
        String stock = req.queryParams("st");
        String funcion = req.queryParams("fn");
        String response = "None";
        CurrentServiceInstance.getInstance().setService(new IexHttpStockService());
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        
        if(stock!=null && stock!=""){
            stockService.setStock(stock);
            
        }else{
            stock="None";
        }
         
        
        if(!cache.inCache(stock)){ 
            try{
                response = stockService.TimeSeries();
            }catch(IOException e){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,e);
            }
            
            cache.addData(stock,response);
        }else{
            response = cache.getData(stock);
        }
        
        
        return response;
    }
    
    
    private static String facadeAlpha(Request req,Response res){
        String stock = req.queryParams("st");
        String funcion = req.queryParams("fn");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getService();
        if(stock!=null && stock!=""){
            stockService.setStock(stock);
            
        }else{
            stock="None";
        }
         if(funcion!=null && funcion!=""){
            stockService.setFuncion(funcion);
            
        }else{
             funcion = "None";
         }
        if(!cache.inCache(stock+funcion)){ 
            try{
                response = stockService.TimeSeries();
            }catch(IOException e){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,e);
            }
            
            cache.addData(stock+funcion,response);
        }else{
            response = cache.getData(stock+funcion);
        }
        
        
        return response;
    }
    

    
}

