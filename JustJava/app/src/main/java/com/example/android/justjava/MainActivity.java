/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;

import static java.text.NumberFormat.getCurrencyInstance;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        int pricePerCup = 15;
//
        CheckBox whippedCreamCheckBox =  findViewById(R.id.check_box_whipped);
        CheckBox chocolateCheckBox =  findViewById(R.id.check_box_chocolate);
        TextInputEditText customerName = findViewById(R.id.name);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(quantity,hasWhippedCream, hasChocolate);
        String summary = orderSummary(customerName.getText().toString(),price, hasWhippedCream, hasChocolate);


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, summary);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    /**
     * This method is called when the pluw button is clicked.
     */
    public void increment(View view) {


        if (quantity == 5 ) {
            Toast.makeText(this ,"You can not order more than 5 cups", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            quantity += 1;
        }
            displayQuantity(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {

        if (quantity == 1 ) {
            Toast.makeText(this ,"You have to order at least a cup", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            quantity -= 1;
        }
        displayQuantity(quantity);

    }



    /**
    * Calculates the price of the order
     *
     *  @return total price
    * */
    private int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {
        int pricePerCup = 5;
        int price = quantity * pricePerCup;

        if (hasChocolate){
            price += (quantity * 2);
        }
        if (hasWhippedCream){
            price += (quantity * 1);
        }

        return price;
    }

    /**
     * Calculates the price of the order
     *
     *  @return total price
     * */
    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * Calculates the price of the order
     *
     *  @return total price
     * */
    private int calculatePrice() {
        int pricePerCup = 5;
        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * Display the order summary
     *
     *  @return summary
     * */
    private String orderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String summary ="Name: " + name;
        summary += "\n" +  getString(R.string.quantity) + ": " + quantity;
        summary += "\n" + getString(R.string.whipped_cream) + "? " + hasWhippedCream;
        summary += "\n" + getString(R.string.chocolate) + "? " + hasChocolate;
        summary += "\nTotal: $" + price +"\nThank you!";
        return summary;
    }



}