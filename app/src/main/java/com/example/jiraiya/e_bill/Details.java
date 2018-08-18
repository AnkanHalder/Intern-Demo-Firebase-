package com.example.jiraiya.e_bill;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Details extends AppCompatActivity {

    TextView address,dateTime,discount,endTime,grandTotal,
    jobassign,paymentStatus,rate,serviceLocation,servicerequired,
    startTime,status,taxcgst,taxsgst,totalTime,typeOfWork;

    String value;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        address=(TextView)findViewById(R.id.address);
        dateTime=(TextView)findViewById(R.id.dateTime);
        discount=(TextView)findViewById(R.id.discount);
        endTime=(TextView)findViewById(R.id.endTime);
        grandTotal=(TextView)findViewById(R.id.grandTotal);
        jobassign=(TextView)findViewById(R.id.jobassign);
        paymentStatus=(TextView)findViewById(R.id.paymentStatus);
        rate=(TextView)findViewById(R.id.rate);
        serviceLocation=(TextView)findViewById(R.id.servicelocation);
        servicerequired=(TextView)findViewById(R.id.servicerequired);
        startTime=(TextView)findViewById(R.id.startTime);
        status=(TextView)findViewById(R.id.status);
        taxcgst=(TextView)findViewById(R.id.taxcgst);
        taxsgst=(TextView)findViewById(R.id.taxsgst);
        totalTime=(TextView)findViewById(R.id.totalTime);
        typeOfWork=(TextView)findViewById(R.id.typeOfWork);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
            value = extras.getString("ID");

        progressDialog =new ProgressDialog(Details.this);
        progressDialog.setMessage("Fetching Id "+ value);
        progressDialog.show();

        //Get Database Instance
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Data").child(value);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GetSetDetails gsd = dataSnapshot.getValue(GetSetDetails.class);


                address.setText(gsd.getAddress());
                dateTime.setText(gsd.getDateTime());
                discount.setText(gsd.getDiscount());
                endTime.setText(gsd.getEndTime());
                grandTotal.setText(gsd.getGrandTotal());
                jobassign.setText(gsd.getJobassign());
                paymentStatus.setText(gsd.getPaymentStatus());
                rate.setText(gsd.getRate());
                servicerequired.setText(gsd.getServicerequired());
                serviceLocation.setText(gsd.getServiceLocation());
                startTime.setText(gsd.getStartTime());
                status.setText(gsd.getStatus());
                taxcgst.setText(gsd.getTaxcgst());
                taxsgst.setText(gsd.getTaxsgst());
                totalTime.setText(gsd.getTotalTime());
                typeOfWork.setText(gsd.getTypeOfWork());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        progressDialog.dismiss();


    }
}
