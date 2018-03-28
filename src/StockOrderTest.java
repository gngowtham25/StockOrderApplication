import com.stockorderapp.model.StockOrderModel;
import com.stockorderapp.util.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockOrderTest {

    public static ArrayList<StockOrderModel> stockList = new ArrayList<StockOrderModel>(); //contains all the stock details
    public static ArrayList<StockOrderModel> expectedList = new ArrayList<StockOrderModel>(); //contains all the stock details

    @Test
    public void test() {
        fillData();
        StockOrderTransactions stocksToTransact = new StockOrderTransactions(new StockOrderProcessing());
        stocksToTransact.transact(stockList);
        Assert.assertTrue(matchData(stockList));
    }

    public void fillData() {

        StockModelConstruction constructStockList = new StockModelConstruction(new ConstructStockOrder());

        stockList.add(constructStockList.constructStock(1, "Buy", "ABC", 10));
        stockList.add(constructStockList.constructStock(2, "Sell", "XYZ", 15));
        stockList.add(constructStockList.constructStock(3, "Sell", "ABC", 13));
        stockList.add(constructStockList.constructStock(4, "Buy", "XYZ", 10));
        stockList.add(constructStockList.constructStock(5, "Buy", "XYZ", 8));

        expectedList.add(constructStockList.constructStock(1, "Buy", "ABC", 10,0, StockOrderStatus.CLOSED));
        expectedList.add(constructStockList.constructStock(2, "Sell", "XYZ", 15, 0, StockOrderStatus.CLOSED));
        expectedList.add(constructStockList.constructStock(3, "Sell", "ABC", 13, 3, StockOrderStatus.OPEN));
        expectedList.add(constructStockList.constructStock(4, "Buy", "XYZ", 10, 0, StockOrderStatus.CLOSED));
        expectedList.add(constructStockList.constructStock(5, "Buy", "XYZ", 8, 3, StockOrderStatus.OPEN));

    }

    public boolean matchData(ArrayList<StockOrderModel> stockList) {

        for(int stockIterator = 0; stockIterator < stockList.size(); stockIterator++) {

            StockOrderModel actualStockModel = stockList.get(stockIterator);
            StockOrderModel expectedStockModel = expectedList.get(stockIterator);

            if(actualStockModel.qtyCompare(expectedStockModel) != 0) {
               return false;
            }

        }
        return true;

    }
}
