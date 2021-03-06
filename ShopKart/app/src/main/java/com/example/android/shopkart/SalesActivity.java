package com.example.android.shopkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SalesActivity extends AppCompatActivity {
    RecyclerView recycler;


    private RecyclerView.LayoutManager layoutManager;
//    @BindView(R.id.loadingPanel)
//    ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sales);
        CardView cardView = findViewById(R.id.salesCard);


        recycler = findViewById(R.id.recyclerSales);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        getSales();
        }

        private void getSales(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Sales>> call = api.getSales();

        call.enqueue(new Callback<List<Sales>>() {
            @Override
            public void onResponse(Call<List<Sales>> call, Response<List<Sales>> response) {
//                spinner.setVisibility(View.GONE);
                Log.i("url", call.request().url().toString());
                List<Sales> sales=response.body();

                recycler.setAdapter(new SalesAdapter(SalesActivity.this,sales));
            }

            @Override
            public void onFailure(Call<List<Sales>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


        }
}
