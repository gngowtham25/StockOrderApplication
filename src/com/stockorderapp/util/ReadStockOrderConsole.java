package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gowtham on 17/03/18.
 */
public class ReadStockOrderConsole {

    public void getDataFromConsole(ArrayList<StockOrderModel> stockList){

        StockModelConstruction constructStockList = new StockModelConstruction(new ConstructStockOrder());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of stocks transaction");

        try {

            int numberOfOrders = Integer.parseInt(scanner.nextLine());

            for (int getOrderIterator = 0; getOrderIterator <= numberOfOrders; getOrderIterator++) {

                System.out.println("Enter the Stock Order Number");
                int stockOrderNumber = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the Operation side of Stock Order Number " + stockOrderNumber);
                String operationSide = scanner.nextLine();

                System.out.println("Enter the Company Name Stock Order Number " + stockOrderNumber);
                String companyName = scanner.nextLine();

                System.out.println("Enter the Quantity of Stock Order Number " + stockOrderNumber);
                int stockQuantity = Integer.parseInt(scanner.nextLine());

                stockList.add(constructStockList.constructStock(stockOrderNumber, operationSide, companyName, stockQuantity));

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
