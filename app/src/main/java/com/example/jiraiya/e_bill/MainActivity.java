package com.example.jiraiya.e_bill;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView orderRecyclerView;
    private RecyclerView.Adapter ordersAdapter;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference child;

    private List<GetSetMyOrder> orders;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach XML with Code
        orderRecyclerView = (RecyclerView)findViewById(R.id.orders_recyclerview);
        orderRecyclerView.setHasFixedSize(true);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Get Database Instance
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        //Adding a ProgressDialog
        progressDialog = new ProgressDialog(MainActivity.this);


        orders = new ArrayList<>();
        ordersAdapter = new MyOrderAdapter(orders, this);
        orderRecyclerView.setAdapter(ordersAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(!isNetworkConnected()){
            Intent pop =new Intent(MainActivity.this,Popup.class);
            startActivity(pop);
        }
            progressDialog.setMessage("Please wait..");
            progressDialog.show();


        child = databaseReference.child("Users").child("User1").child("Orders");
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ordersdb = dataSnapshot.getChildren();



                for(DataSnapshot dShot : ordersdb){
                    Log.d("Data ", String.valueOf(dShot.child("name")));
                    GetSetMyOrder gso = dShot.getValue(GetSetMyOrder.class);
                    orders.add(gso);
                    ordersAdapter.notifyDataSetChanged();
                }

                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    @Override
    protected void onPause() {
        super.onPause();
        orders.clear();
        ordersAdapter.notifyDataSetChanged();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
