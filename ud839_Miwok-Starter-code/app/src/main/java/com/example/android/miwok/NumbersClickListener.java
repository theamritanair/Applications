package com.example.android.miwok;

import android.widget.Toast;
import android.view.View;


public class NumbersClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
    }
}
