package com.example.android.shopkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Phone> phoneList = new ArrayList<>();

    private RecyclerView.Adapter phoneAdapter;
    private RecyclerView.LayoutManager layoutManager;


    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = (CardView) findViewById(R.id.phoneCard);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
         layoutManager=new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        getPhone();

    }

    private void getPhone() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);

        Call<List<Phone>> call = api.getPhone();

        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                List<Phone> list=response.body();

                for(int i=0;i<list.size();i++){
                    String model=(list.get(i).getModel());
                    String url=(list.get(i).getImageUrl());
                    phoneList.add( new Phone(model,url));
                }
                recyclerView.setAdapter(new PhoneAdapter(getApplicationContext(),phoneList));
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }





}

