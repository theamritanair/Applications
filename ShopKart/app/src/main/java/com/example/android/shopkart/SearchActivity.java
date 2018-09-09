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
    EditText modelName;

    @BindView(R.id.manufacturerName)
    EditText manufacturerName;

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


        String manufacturer = manufacturerName.getText().toString();
        if(manufacturer.equals("")){
            manufacturer = null;
        }

        String model = modelName.getText().toString();
        if(model.equals("")){
            model = null;
        }
        String minprice = minPrice.getText().toString();
        if(minprice.equals("")){
            minprice = null;
        }

        String maxprice = maxPrice.getText().toString();
        if(maxprice.equals("")){
            maxprice = null;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("manufacturer",manufacturer);
        intent.putExtra("model",model);
        intent.putExtra("minPrice",minprice);
        intent.putExtra("maxPrice",maxprice);

        startActivity(intent);

    }
}
