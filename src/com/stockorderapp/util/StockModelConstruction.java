package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockModelConstruction {

    private StockConstructable _constructStock;

    public StockModelConstruction(StockConstructable constructStock){
        this._constructStock = constructStock;
    }

    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity){
        return _constructStock.constructStock(stockId,operationSide,companyName,quantity);
    }

    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity, int remainingQty, StockOrderStatus status){
        return _constructStock.constructStock(stockId,operationSide,companyName,quantity, remainingQty, status);
    }
}
