package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 18/03/18.
 */
public interface Printable {

    public void printStocks(ArrayList<StockOrderModel> stockLists);
}
