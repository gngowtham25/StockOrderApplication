package com.stockorderapp.util;

/**
 * Created by Gowtham on 18/03/18.
 */
public class ApplicationEntryAction implements ApplicationStartable {

    public void startAction(){

        CSVReaderCustomAction csvReader = new CSVReaderCustomAction(new ReadStockOrderCSV());
        csvReader.readCSVData();
    }
}
