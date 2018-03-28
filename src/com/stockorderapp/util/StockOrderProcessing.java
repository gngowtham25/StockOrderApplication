package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;

/**
 * Created by Gowtham on 17/03/18.
 */
public class StockOrderProcessing extends StockTransactions implements Transactable {


    public void transact(ArrayList<StockOrderModel> stockList) {

        int sourceStockCounter = 0;
        for (StockOrderModel sourceStockOrder : stockList) {

            if(sourceStockOrder.isValidQty())
                manipulateStocks(stockList, sourceStockCounter, sourceStockOrder);

            sourceStockCounter++;

        }

        StockPrinter stocksToPrint = new StockPrinter(new PrintCalculatedStock());
        stocksToPrint.printStocks(stockList);

    }


    private void manipulateStocks(ArrayList<StockOrderModel> stockList, int sourceStockCounter, StockOrderModel sourceStockOrder) {

        for (int targetStockIterator = sourceStockCounter+1; targetStockIterator < stockList.size(); targetStockIterator++) {

            StockOrderModel targetStockOrder = stockList.get(targetStockIterator);

            if (sourceStockOrder.isValidCompany(targetStockOrder) && sourceStockOrder.isValidQty() && targetStockOrder.isValidQty()) {

                if (sourceStockOrder.isOppositeOperation(targetStockOrder)) {

                    if (targetStockOrder.qtyCompare(sourceStockOrder) == 1) {
                        targetStockOrder.calculateRemainingQty(sourceStockOrder);
                        sourceStockOrder.setRemainingQtyZero();

                    } else if (targetStockOrder.qtyCompare(sourceStockOrder) == 0) {
                        sourceStockOrder.setRemainingQtyZero();
                        targetStockOrder.setRemainingQtyZero();

                    } else {
                        sourceStockOrder.calculateRemainingQty(targetStockOrder);
                        targetStockOrder.setRemainingQtyZero();
                    }

                }
            }

        }
    }

}
