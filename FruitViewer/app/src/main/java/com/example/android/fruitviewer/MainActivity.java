package com.example.android.fruitviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fruit> fruitList ;

    private RecyclerView.Adapter fruitAdapter;

    @BindView(R.id.fruitViewer)
    RecyclerView fruitViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fruitAdapter = new FruitAdapter(createFruits());

        fruitViewer.setAdapter(fruitAdapter);

    }


    public ArrayList<Fruit> createFruits() {
        fruitList= new ArrayList<Fruit>();

        fruitList.add(new Fruit("Apple",R.drawable.apple));
        fruitList.add(new Fruit("Banana",R.drawable.banana));
        fruitList.add(new Fruit("Blueberries",R.drawable.blueberries));
        fruitList.add(new Fruit("Cherries",R.drawable.cherries));
        fruitList.add(new Fruit("Grapes",R.drawable.grapes));
        fruitList.add(new Fruit("Orange",R.drawable.orange));
        fruitList.add(new Fruit("Peach",R.drawable.peach));
        fruitList.add(new Fruit("Pear",R.drawable.pear));
        fruitList.add(new Fruit("Pineapple",R.drawable.pineapple));
        fruitList.add(new Fruit("Pomegranate",R.drawable.pomegranate));
        fruitList.add(new Fruit("Raspberry",R.drawable.raspberry));
        fruitList.add(new Fruit("Strawberry",R.drawable.strawberry));
        fruitList.add(new Fruit("Watermelon",R.drawable.watermelon));




        return fruitList;
    }
}
