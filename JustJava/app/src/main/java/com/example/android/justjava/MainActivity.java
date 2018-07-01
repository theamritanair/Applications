package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity);
      String summaryMessage = createOrderSummary(price);
      displayMessage(summaryMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */

    public void increment(View view){

        quantity+=1;
        displayQuantity(quantity);

    }
    public void decrement(View view){
        quantity-=1;
        displayQuantity(quantity);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    public int calculatePrice(int quantity){
        int price = quantity*5;
        return price;
    }

    public String createOrderSummary(int price){
        String summaryMessage = "Name: Alaska O'Neal";
       summaryMessage = summaryMessage + "\n Quantity: "+ quantity;
       summaryMessage = summaryMessage +"\n Total: $" +price +"\n Thank You!";
       return summaryMessage;
    }
}
