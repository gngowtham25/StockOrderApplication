package com.stockorderapp.util;

/**
 * Created by Gowtham on 18/03/18.
 */
public class ApplicationCustomOperation {

    private ApplicationStartable _appStart;

    public ApplicationCustomOperation(ApplicationStartable appStart){
        this._appStart = appStart;
    }

    public void startAction(){
        this._appStart.startAction();
    }
}
