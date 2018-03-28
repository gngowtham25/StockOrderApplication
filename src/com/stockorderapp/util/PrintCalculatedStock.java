package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 17/03/18.
 */
public class PrintCalculatedStock implements Printable {

    public void printStocks(ArrayList<StockOrderModel> stockLists){

        System.out.println("StockId\t\t\t\tSide\t\t\t\tCompany\t\t\t\tQuantity\t\t\t\tStatus");

        for(StockOrderModel eachStock : stockLists){
           System.out.println(eachStock.toString());
        }
    }
}
