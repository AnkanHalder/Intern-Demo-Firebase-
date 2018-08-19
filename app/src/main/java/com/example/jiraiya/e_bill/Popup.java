package com.example.jiraiya.e_bill;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class Popup extends Activity {

    private BroadcastInternetConnection bic;
    public static int statusInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        bic =new BroadcastInternetConnection(Popup.this);
        registerNetworkBroadcastForNougat();
        bic.internet(Popup.this);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);



        int height =dm.heightPixels;
        int width =dm.widthPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));



    }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterNetworkChanges();
    }

    @Override
    public void onBackPressed() {
        if(isNetworkConnected())
            super.onBackPressed();
    }


    private void registerNetworkBroadcastForNougat() {
        registerReceiver(bic, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    protected void unregisterNetworkChanges() {
        try {
            unregisterReceiver(bic);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
