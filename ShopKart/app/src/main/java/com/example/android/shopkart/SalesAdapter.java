package com.example.android.shopkart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.salesViewHolder> {

    private Context context;

    List<Sales> salesList;

    public SalesAdapter(Context context, List<Sales> list) {
        this.context = context;
        this.salesList = list;
    }

    @NonNull
    @Override
    public salesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_sales, parent, false);
        return new salesViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull salesViewHolder holder, int position) {
    Sales sale = salesList.get(position);
    holder.invoiceNumber.setText("Invoice Number: "+ sale.getInvoiceNumber());
    holder.username.setText("Username: "+sale.getUsername());
    holder.quantity.setText("Quantity: "+sale.getQuantity());
    holder.model.setText("Model: "+sale.getModel());


    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }


    public class salesViewHolder extends RecyclerView.ViewHolder {
        TextView invoiceNumber;
        TextView username;
        TextView quantity;
        TextView model;

        public salesViewHolder(View itemView) {
            super(itemView);

            model = (TextView) itemView.findViewById(R.id.modelSales);
            invoiceNumber = (TextView) itemView.findViewById(R.id.invoice);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            username = (TextView) itemView.findViewById(R.id.usernamesales);

        }


    }
}
