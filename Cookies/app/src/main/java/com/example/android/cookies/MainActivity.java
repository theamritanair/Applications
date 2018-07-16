package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.android_cookie_image_view)
    ImageView imageView;

    @BindView(R.id.status_text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
//        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);
        // TODO: Find a reference to the ImageView in the layout. Change the image.
//        TextView textView = (TextView) findViewById(R.id.status_text_view);
        textView.setText("I'm so full");
        // TODO: Find a reference to the TextView in the layout. Change the text.

    }
}
