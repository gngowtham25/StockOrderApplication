package com.stockorderapp.util;

import com.stockorderapp.model.StockOrderModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Gowtham on 17/03/18.
 */
public class ReadStockOrderCSV implements CSVReadable{

    public static ArrayList<StockOrderModel> stockList = null; //contains all the stock details

    public ReadStockOrderCSV(){
        stockList = new ArrayList<StockOrderModel>();
    }


    public void readCSVData(){

        String stockCSVFilePath = System.getProperty("user.dir") + File.separator + "StockOrderList.csv";
        String stockDetails = "";

        StockModelConstruction constructStockList = new StockModelConstruction(new ConstructStockOrder());
        StockCSVFileValidator csvFileValidator = new StockCSVFileValidator();
        StockDetailsValidator validateDetails = new StockDetailsValidator();


        if(validateDetails.validate(csvFileValidator,stockCSVFilePath)) {
            try (BufferedReader inputBuffer = new BufferedReader(new FileReader(stockCSVFilePath))) {
                inputBuffer.readLine();
                while ((stockDetails = inputBuffer.readLine()) != null && stockDetails.length()>0) {
                    StringTokenizer eachLineValues = new StringTokenizer(stockDetails);
                    ArrayList<String> tokens = new ArrayList<String>();
                    while (eachLineValues.hasMoreTokens()) {
                        tokens.add(eachLineValues.nextToken());
                    }
                    stockList.add(constructStockList.constructStock(Integer.parseInt(tokens.get(0)), tokens.get(1), tokens.get(2), Integer.parseInt(tokens.get(3))));
                }

                StockOrderTransactions stocksToTransact = new StockOrderTransactions(new StockOrderProcessing());
                stocksToTransact.transact(stockList);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
