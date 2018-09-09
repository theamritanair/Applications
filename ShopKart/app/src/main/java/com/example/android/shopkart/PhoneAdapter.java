package com.example.android.shopkart;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.preference.ListPreference;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.phoneViewHolder> {
    private Context context;

    List<Phone> phoneList;


    public PhoneAdapter(Context context, List<Phone> list) {
        this.context = context;
        this.phoneList = list;
    }

    @NonNull
    @Override
    public phoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_xml,parent,false);

        return new phoneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final phoneViewHolder holder, int position)    {

        Phone phone = phoneList.get(position);
        Picasso.with(context).load(phone.getImage()).placeholder(R.drawable.placeholder).error(R.drawable.error).into(holder.image);
        Log.v("hello","Image appears");
        holder.model.setText(" "+phone.getModel());
        final String modelName = phoneList.get(position).getModel();
        holder.manufacturer.setText((""+ phone.getManufacturer()));
        holder.price.setText(""+phone.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());

                LayoutInflater layoutInflater = LayoutInflater.from(holder.itemView.getContext());
                final View dialog = layoutInflater.inflate(R.layout.dialoguelayout, null);
                builder.setView(dialog);

                final EditText username = dialog.findViewById(R.id.username);
                final EditText quantity = dialog.findViewById(R.id.quantity);
                builder.setTitle("Buy");
                builder.setMessage("Enter both the values to Buy");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String name = username.getText().toString();
                        String quan = quantity.getText().toString();

                        if(!name.equals("")&&!quan.equals("")){
                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(Api.BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();

                            Api api = retrofit.create(Api.class);
                            Call<Buy> call;
                            Integer quantityNumber = Integer.parseInt(quan);
                             call = api.getBuy(modelName,name, quantityNumber);

                             call.enqueue(new Callback<Buy>() {
                                 @Override
                                 public void onResponse(Call<Buy> call, Response<Buy> response) {
                                     Log.v("url", call.request().url().toString());
                                     Toast.makeText(holder.itemView.getContext(), "Bought", Toast.LENGTH_SHORT).show();


                                 }

                                 @Override
                                 public void onFailure(Call<Buy> call, Throwable t) {
                                     Toast.makeText(holder.itemView.getContext(),
                                             "No Internet Connection",
                                             Toast.LENGTH_SHORT).show();
                                 }
                             });

                        }else{
                            dialogInterface.dismiss();
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                   alert.show();

            }

        });

    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }


    public class phoneViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView model;
        TextView manufacturer;
        TextView price;

        public phoneViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.phoneImage);
            model = (TextView) itemView.findViewById(R.id.phoneText);
            manufacturer = (TextView) itemView.findViewById(R.id.phoneManufacturer);
            price= (TextView)itemView.findViewById(R.id.phonePrice);

        }
    }
}
