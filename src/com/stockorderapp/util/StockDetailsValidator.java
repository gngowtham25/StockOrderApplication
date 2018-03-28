package com.stockorderapp.util;

/**
 * Created by Gowtham on 18/03/18.
 */
public class StockDetailsValidator {

    public boolean validate(GenericCSVValidation validator,String filePath){

        return validator.isCSVFileValid(filePath);

    }
}
