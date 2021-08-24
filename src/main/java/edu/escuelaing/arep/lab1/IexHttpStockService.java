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
public class IexHttpStockService extends HttpStockService{
    
    String stock = "fb";
    String URL = "https://cloud.iexapis.com/stable/tops?token=YOUR_TOKEN_HERE&symbols="+stock;
    @Override
    public String getURL() {
        System.out.println(URL);
        return URL;
        
    }

    @Override
    public void setStock(String stock) {
        stock = stock.replace("\"", "");
        this.stock = stock;
        System.out.println(stock);
        URL =  "https://cloud.iexapis.com/stable/tops?token=YOUR_TOKEN_HERE&symbols="+stock;
    }

    @Override
    public void setFuncion(String funcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
