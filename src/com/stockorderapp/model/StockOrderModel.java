package com.stockorderapp.model;

import com.stockorderapp.util.StockOrderStatus;

import java.util.ArrayList;

/**
 * Created by Gowtham on 17/03/18.
 */
public class StockOrderModel {

    private int stockOrderId;
    private String operationSide;
    private String companyName;
    private int quantity;
    private int remainingQty;
    private StockOrderStatus stockOrderStatus;


//    public String getStockOrderStatus() {
//        return stockOrderStatus;
//    }
//
//    public void setStockOrderStatus(String stockOrderStatus) {
//        this.stockOrderStatus = stockOrderStatus;
//    }
//
//    public int getStockOrderId() {
//        return stockOrderId;
//    }
//
//    public void setStockOrderId(int stockOrderId) {
//        this.stockOrderId = stockOrderId;
//    }
//
//    public String getOperationSide() {
//        return operationSide;
//    }
//
//    public void setOperationSide(String operationSide) {
//        this.operationSide = operationSide;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public int getRemainingQty() {
//        return remainingQty;
//    }
//
//    public void setRemainingQty(int remainingQty) {
//        this.remainingQty = remainingQty;
//    }


    public StockOrderModel(int stockOrderId, String operationSide, String companyName, int quantity){
        this.stockOrderId = stockOrderId;
        this.operationSide = operationSide;
        this.companyName = companyName;
        this.quantity = quantity;
        this.remainingQty = quantity;
        this.stockOrderStatus = StockOrderStatus.OPEN;
    }

    public StockOrderModel(int stockOrderId, String operationSide, String companyName, int quantity, int remainingQty, StockOrderStatus status){
        this.stockOrderId = stockOrderId;
        this.operationSide = operationSide;
        this.companyName = companyName;
        this.quantity = quantity;
        this.remainingQty = remainingQty;
        this.stockOrderStatus = status;
    }


    public boolean isValidCompany(StockOrderModel another){

        return this.companyName.equals(another.companyName);
    }

    public boolean isValidQty(){
        return this.remainingQty > 0;
    }

    public boolean isOpenStatus(){
        return this.stockOrderStatus == StockOrderStatus.OPEN;
    }

    public boolean isOppositeOperation(StockOrderModel another){
        return !this.operationSide.equals(another.operationSide);
    }

    @Override
    public String toString() {
        return
                stockOrderId + "\t\t\t\t"
                        + operationSide + "\t\t\t\t"
                        + companyName + "\t\t\t\t"
                        + quantity + ","
                        + remainingQty + "\t\t\t\t"
                        + this.getStatus() + "\t\t\t\t";
    }

    public int qtyCompare(StockOrderModel another){
        if(this.remainingQty > another.remainingQty){
            return 1;
        } else if(this.remainingQty == another.remainingQty){
            return 0;
        } else {
            return -1;
        }
    }

    public void setRemainingQtyZero(){
        this.remainingQty = 0;
    }

    public void calculateRemainingQty(StockOrderModel another){
        this.remainingQty = this.remainingQty - another.remainingQty;
    }

    public StockOrderStatus getStatus(){
        return this.remainingQty > 0 ? StockOrderStatus.OPEN : StockOrderStatus.CLOSED;
    }





}
