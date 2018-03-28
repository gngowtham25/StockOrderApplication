package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

/**
 * Created by Gowtham on 17/03/18.
 */
public class ConstructStockOrder implements StockConstructable {


    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity){
        return new StockOrderModel(stockId,operationSide,companyName,quantity);
    }

    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity, int remainingQty, StockOrderStatus status){
        return new StockOrderModel(stockId,operationSide,companyName,quantity,remainingQty,status);
    }

}
