package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 17/03/18.
 */
public abstract class StockTransactions {

    public abstract void transact(ArrayList<StockOrderModel> stockList);

}