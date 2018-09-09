package com.example.android.shopkart;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    @BindView(R.id.loadingPanel)
            ProgressBar spinner;


    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();






        cardView = (CardView) findViewById(R.id.phoneCard);
        recyclerView =
                findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api = retrofit.create(Api.class);


        Call<List<Phone>> call;



            if(bundle!=null) {
                String model = bundle.getString("model");
                String manufacturer = bundle.getString("manufacturer");
                Integer minprice = bundle.getInt("minprice");
                Integer maxprice = bundle.getInt("maxprice");


                if (model == null && manufacturer == null && minprice == 0 && maxprice == 0) {

                    call = api.getPhone();
                } else {

                    call = api.getPhone(manufacturer, model, minprice, maxprice);
                }


                call.enqueue(new Callback<List<Phone>>() {
                    @Override
                    public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                        spinner.setVisibility(View.GONE);
                        Log.i("url", call.request().url().toString());
                        List<Phone> list = response.body();

//                for(int i=0;i<list.size();i++){
//                    String model=(list.get(i).getModel());
//                    String url=(list.get(i).getImageUrl());
//                    phoneList.add( new Phone(model,url));
//                }
                        recyclerView.setAdapter(new PhoneAdapter(MainActivity.this, list));

//                renderPhones(list);
                    }

                    @Override
                    public void onFailure(Call<List<Phone>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.search){
            search();
        }else if(id==R.id.shop){
            sales();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        (new AlertDialog.Builder(this))
                .setTitle("Confirm action")
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent in = new Intent("com.test.START");
                        startActivity(in);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void search(){
            Intent intent = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(intent);


    }
    public void sales(){
        Intent intent = new Intent(this, SalesActivity.class);
        startActivity(intent);
    }

//    public void renderPhones(List<Phone> phone) {
//
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        PhoneAdapter phoneAdapter = new PhoneAdapter(this,phone);
//        recyclerView.setAdapter(phoneAdapter);
//
//
//    }





}

