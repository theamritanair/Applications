package com.example.theamritanair.thingsilike;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.hate_button)
    Button hate;

    @BindView(R.id.love_button)
    Button love;

    @BindView(R.id.love_image)
    ImageView loveImage;

    @BindView(R.id.hate_image)
    ImageView hateImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        love.setOnClickListener(this);
        hate.setOnClickListener(this);



    }

    int[] loveImageList = {R.drawable.litchi2, R.drawable.litchi3,R.drawable.litchi4,R.drawable.litchi5};
    int[] hateImageList = {R.drawable.chiku2, R.drawable.chiku3,R.drawable.chikoo4,R.drawable.chickoo5};


    Random randomNumber = new Random();


    @Override
    public void onClick(View view) {

        if(view == love){
            int v = randomNumber.nextInt(4);
            loveImage.setImageResource(loveImageList[v]);

        }

        if(view == hate){

            int v = randomNumber.nextInt(4);
            hateImage.setImageResource(hateImageList[v]);
        }

    }


}
