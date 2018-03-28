package com.stockorderapp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockCSVFileValidator extends GenericCSVValidation {

    private static List<String> csvFileHeaderContent = Arrays.asList("StockID", "Side", "Company", "Quantity");

    public boolean isCSVFileValid(String filePath) {

        String stockDetails = "";
        try (BufferedReader inputBuffer = new BufferedReader(new FileReader(filePath))) {

            stockDetails = inputBuffer.readLine();
            if (stockDetails != null) {
                StringTokenizer eachLineValues = new StringTokenizer(stockDetails);
                int csvFileHeaderIterator = 0;
                while (eachLineValues.hasMoreTokens()) {
                    if (!eachLineValues.nextToken().equals(csvFileHeaderContent.get(csvFileHeaderIterator))) {
                        throw new Exception("Header mismatch");
                    }
                    csvFileHeaderIterator++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
