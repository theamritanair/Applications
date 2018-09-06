package com.example.android.shopkart;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ImageView image;
    TextView name;
    List<Phone> phoneList;


    public PhoneAdapter(Context context, List<Phone> list) {
        this.context = context;
        this.phoneList = list;
    }


    @NonNull
    @Override
    public phoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_xml, parent, false);
        phoneViewHolder viewHolder = new phoneViewHolder(v);
        return new phoneViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Phone phone =phoneList.get(position);
        Picasso.with(context).load(Uri.parse(phone.getImageUrl())).fit().into(image);
        name.setText(phoneList.get(position).getModel());
    }


    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class phoneViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);


        public phoneViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.phoneImage);
            name = (TextView) itemView.findViewById(R.id.phoneText);
        }
    }
}
