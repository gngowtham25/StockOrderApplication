package com.stockorderapp.util;

/**
 * Created by Gowtham on 18/03/18.
 */
public class CSVReaderCustomAction {

    private CSVReadable _csvReadable;

    public CSVReaderCustomAction(CSVReadable csvReadable){

        this._csvReadable = csvReadable;
    }

    public void readCSVData(){
        this._csvReadable.readCSVData();
    }

}
