package com.example.android.fruitviewer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.fruitViewHolder> {

    private ArrayList<Fruit> fruitNamesList;




    public FruitAdapter(ArrayList<Fruit> fruits) {

        fruitNamesList = fruits;

    }

    @NonNull
    @Override
    public fruitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new fruitViewHolder(LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.layout,viewGroup,false));


    }

    @Override
    public void onBindViewHolder(@NonNull fruitViewHolder fruitViewHolder, int position) {
        fruitViewHolder.fruitImageview.setImageResource(fruitNamesList.get(position).getImage());
        fruitViewHolder.fruitNameView.setText(fruitNamesList.get(position).getFruitName());



    }

    @Override
    public int getItemCount() {

        return fruitNamesList.size();
    }


    class fruitViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_fruitImage)
        ImageView fruitImageview;

        @BindView(R.id.tv_fruitnames)
        TextView fruitNameView;

        public fruitViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
