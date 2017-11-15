/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity{

    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void more(View view){
        numberOfCoffees+=1;
        display(numberOfCoffees);
    }

    public void minus(View view){
        numberOfCoffees-=1;
        display(numberOfCoffees);
    }

    public void submitOrder(View view) {
            displayPrice(numberOfCoffees * 2);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        if (number<=0){
            Toast.makeText(MainActivity.this, "0 or negative number is not permited", Toast.LENGTH_LONG).show();
        }else{
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + number);
        }
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}