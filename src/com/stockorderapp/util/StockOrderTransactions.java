package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockOrderTransactions {

    private Transactable _transact;

    public StockOrderTransactions(Transactable transact){
        this._transact = transact;
    }

    public void transact(ArrayList<StockOrderModel> stockLists){
        _transact.transact(stockLists);
    }
}
