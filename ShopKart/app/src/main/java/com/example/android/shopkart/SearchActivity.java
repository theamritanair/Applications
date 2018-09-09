package com.example.android.shopkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.modelName)
    EditText model;

    @BindView(R.id.manufacturerName)
    EditText manufacturer;

    @BindView(R.id.minPrice)
    EditText minPrice;

    @BindView(R.id.maxPrice)
    EditText maxPrice;

    @BindView(R.id.search)
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);





    }


    public void search(View view){


        Intent intent=new Intent(SearchActivity.this,MainActivity.class);

        Bundle bundle=new Bundle();

        String manufacturerName = manufacturer.getText().toString();
        if(manufacturerName.equals("")){
            manufacturerName=null;
        }
        bundle.putString("manufacturer",manufacturerName);

        String modelName = model.getText().toString();
        if(modelName.equals("")){
            modelName = null;
        }
        bundle.putString("model",modelName);
        String minprice = minPrice.getText().toString();
        if(minprice.equals("")){
            minprice = null;
        }
        bundle.putInt("minprice",Integer.parseInt(minprice));

        String maxprice = maxPrice.getText().toString();
        if(maxprice.equals("")){
            maxprice = null;
        }
        bundle.putInt("maxprice",Integer.parseInt(maxprice));
        intent.putExtras(bundle);


        startActivity(intent);

    }
}
