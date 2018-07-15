package com.example.android.fruitviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fruitNameList ;
    private ArrayList<Integer> fruitImages;


    private RecyclerView.Adapter fruitAdapter;

    @BindView(R.id.fruitViewer)
    RecyclerView fruitViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fruitAdapter = new FruitAdapter(createFruits(),getFruitImageList());

        fruitViewer.setAdapter(fruitAdapter);

    }

    public ArrayList<String> createFruits() {
        fruitNameList = new ArrayList<String>();
        fruitNameList.add("Apple");
        fruitNameList.add("Banana");
        fruitNameList.add("BlueBerries");
        fruitNameList.add("Cherries");
        fruitNameList.add("Grapes");
        fruitNameList.add("Orange");
        fruitNameList.add("Peach");

        fruitNameList.add("Pear");
        fruitNameList.add("Pineapple");
        fruitNameList.add("Pomegranate");
        fruitNameList.add("Raspberry");
        fruitNameList.add("Strawberry");
        fruitNameList.add("Watermelon");
        Log.v("Fruit List",fruitNameList.toString());

        return fruitNameList;


    }

    public ArrayList<Integer> getFruitImageList() {
        fruitImages= new ArrayList<Integer>();

        fruitImages.add(R.drawable.apple);
        fruitImages.add(R.drawable.banana);
        fruitImages.add(R.drawable.blueberries);
        fruitImages.add(R.drawable.cherries);
        fruitImages.add(R.drawable.grapes);
        fruitImages.add(R.drawable.orange);
        fruitImages.add(R.drawable.peach);
        fruitImages.add(R.drawable.pear);
        fruitImages.add(R.drawable.pineapple);
        fruitImages.add(R.drawable.pomegranate);
        fruitImages.add(R.drawable.raspberry);
        fruitImages.add(R.drawable.strawberry);
        fruitImages.add(R.drawable.watermelon);




        return fruitImages;
    }
}
