package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

/**
 * Created by Gowtham on 18/03/18.
 */
public interface StockConstructable {

    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity);
    public StockOrderModel constructStock(int stockId, String operationSide, String companyName, int quantity, int remainingQty, StockOrderStatus status);
}
