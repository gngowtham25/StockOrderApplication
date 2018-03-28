import com.stockorderapp.util.*;

/**
 * Created by Gowtham on 17/03/18.
 */
public class StockOrderMain {


    public static void main(String args[]){

        startApplication();
    }

    private static void startApplication(){

        ApplicationCustomOperation appOperation = new ApplicationCustomOperation(new ApplicationEntryAction());
        appOperation.startAction();

    }

}


