package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockPrinter {

    private Printable _printStock;

    public StockPrinter(Printable printStocks){
        this._printStock = printStocks;
    }

    public void printStocks(ArrayList<StockOrderModel> stock){
        _printStock.printStocks(stock);
    }
}
