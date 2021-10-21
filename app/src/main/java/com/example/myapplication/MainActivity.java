
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;


    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if(quantity>=100)
        {
            Toast.makeText(this, "100 IS THE MAXIMUM CUP OF COFFE WE CAN SERVE",Toast.LENGTH_SHORT).show();
            return;
        }


        quantity = quantity + 1;
        display(quantity);


    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if(quantity<=0)
        {
            Toast.makeText(this, "ORDER ATLEAST ONE CUP OF COFFE",Toast.LENGTH_SHORT).show();

            return;
        }

        quantity = quantity - 1;
        display(quantity);


    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText text = (EditText) findViewById(R.id.editText);
        String name = text.getText().toString();
        CheckBox hasclicked = (CheckBox) findViewById(R.id.checkBox);
        boolean hasstickers = hasclicked.isChecked();
        CheckBox hasclicked2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean hasMUGS = hasclicked2.isChecked();

        int priceofshirts = displayPrice(hasstickers, hasMUGS);
        String priceMessage = "NAME:" + name + "\nQUANTITY: " + quantity + "\nPRICE: " + priceofshirts + "\nINCLUDE STICKERS:" + hasstickers + "\nINCLUDE MUGS:" + hasMUGS + "\nTHANK YOU!\n";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "THE INFORMATION FOR BUYING TSHIRTS");
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        intent.setType("text/plain");
        startActivity(intent);

        displayMessage(priceMessage);


    }


    private void displayMessage(String n) {
        TextView priceTextView = (TextView) findViewById(R.id.textViewpriceprint);
        priceTextView.setText(n);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.forButton);
        quantityTextView.setText("" + number);
    }

    /**
     * this method retun the total price
     */
    private int displayPrice(boolean a, boolean b) {
       int price= 400;
        if (a)
        {
            price=price+10;
        }
        if(b)
        {
            price=price+20;
        }
        return price*quantity;


    }
}
