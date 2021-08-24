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
public class AlphaHttpStockService extends HttpStockService{
    
    String stock = "fb";
    String funcion = "TIME_SERIES_INTRADAY";
    String URL = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+stock+"&interval=5min&apikey=VEAIQDLIRPRZL5WU";
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
        URL =  "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="+stock+"&interval=5min&apikey=VEAIQDLIRPRZL5WU";
    }
    @Override
    public void setFuncion(String funcion){
        funcion = funcion.replace("\"", "");
        this.funcion = funcion;
        URL = "https://www.alphavantage.co/query?function="+ funcion +"&symbol="+stock+"&interval=5min&apikey=VEAIQDLIRPRZL5WU";
    }
    
}
