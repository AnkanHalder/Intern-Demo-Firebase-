package com.example.jiraiya.e_bill;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//Extending to make it a RecyclerView Adapter which needs a Generic Type <VH> View holder
//Which is being created inside the class MyOrderAdapter name OrderHolder which we ar making
//a ViewHolder Type by extending it.


public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.OrderHolder> {

    //Taking a List of type GetSetOrder
    //A Context for attaching

    private List<GetSetMyOrder> orders;
    private Context context;

    //Constructor for initializations

    public MyOrderAdapter(List<GetSetMyOrder> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    //Creating a new ViewHolder(OrderHolder) suppling it with the required params and returning
    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_order_layout,parent,false);

        return new OrderHolder(v);
    }

    //Called after the ViewHolder(OrderHolder) Object is created and populates with the data
    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {

        GetSetMyOrder order = orders.get(position);

        holder.date_time.setText(order.getDateTime());
        holder.status.setText(order.getStatus());
        holder.type_of_work.setText(order.getTypeOfWork());
        holder.id_no.setText(order.getIdNo());
        holder.money.setText(order.getMoney());
        holder.name.setText(order.getName());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OrderHolder extends RecyclerView.ViewHolder{

        public TextView date_time;
        public TextView status;
        public TextView id_no;
        public TextView type_of_work;
        public TextView name;
        public TextView money;

        public OrderHolder(View itemView) {
            super(itemView);

            //Attaching XML with Code

            date_time = (TextView)itemView.findViewById(R.id.date_time);
            status = (TextView)itemView.findViewById(R.id.status);
            id_no = (TextView)itemView.findViewById(R.id.id_no);
            type_of_work = (TextView)itemView.findViewById(R.id.type_of_work);
            name = (TextView)itemView.findViewById(R.id.name);
            money =(TextView)itemView.findViewById(R.id.money);
        }

    }
}
