package com.example.jiraiya.e_bill;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

public class BroadcastInternetConnection extends BroadcastReceiver {

    private Popup popup;

    BroadcastInternetConnection(Popup popup){
        this.popup=popup;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(internet(context)) {
            Popup.statusInternet = 1;
            popup.finish();
            Log.d("Internet","Available");
        }
        else {
            Popup.statusInternet = 0;
            Log.d("Internet","Not Available");
        }
    }

    public boolean internet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
