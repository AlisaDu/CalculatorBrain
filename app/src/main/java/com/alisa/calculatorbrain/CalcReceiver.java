package com.alisa.calculatorbrain;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by alisa on 03-Jan-16.
 */
public class CalcReceiver extends BroadcastReceiver {

    double feedback = 0;
    double value1 = 0;
    double value2 = 0;
    String op = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOrderedBroadcast()) {

            Bundle extras = intent.getExtras();
            if (extras != null) {

                value1 = extras.getDouble("firstOp");
                value2 = extras.getDouble("secondOp");
                op = extras.getString("operation");
            }

            switch (op) {
                case "+": {
                    feedback = value1 + value2;
                    break;
                }
                case "-": {
                    feedback = value1 - value2;
                    break;
                }
                case "*": {
                    feedback = value1 * value2;
                    break;
                }
                case "/": {
                    feedback = value1 / value2;
                    break;
                }
                default:
                    break;
            }// end switch


            setResultCode(Activity.RESULT_OK);
            setResultData(String.valueOf (feedback));


        }
    }

    private double getDouble(String value) {
        double result;
        try {
            result = Double.valueOf(value);
        } catch (Exception e) {

            e.printStackTrace();
            result = 0;
        }
        return result;
    }

}
