package com.example.myapplication;
/**
 * @author Kyle Perry
 */
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import java.text.DecimalFormat;
import java.util.Collections;

public class SpecialtyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RadioButton small;
    private RadioButton medium;
    private RadioButton large;

    private Size getSize(){
        if(small.isChecked()){
            return Size.SMALL;
        } else if (medium.isChecked()){
            return Size.MEDIUM;
        } else return Size.LARGE;
    }
    private CheckBox xsauce;
    private CheckBox xcheese;
    private ListView listview;
    private ObservableArrayList<String> list = new ObservableArrayList<>();
    private ArrayAdapter<String> items;
    private Spinner spinner;
    private ImageView pizzaImage;
    private TextView priceText;
    private TextView sauce;
    private final String[] pizzas = {"Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni", "Hawaiian", "Margherita", "Veggie", "Evil", "Cheese Steak"};
    private ArrayAdapter<String> adapter;

    private final double DELUXE_PRICE = 14.99;
    private final String[] DELUXE_TOPPINGS = {"Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"};

    private final double SUPREME_PRICE = 15.99;
    private final String[] SUPREME_TOPPINGS = {"Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olive", "Mushroom"};

    private final double MEATZZA_PRICE = 16.99;
    private final String[] MEATZZA_TOPPINGS = {"Sausage", "Pepperoni", "Beef", "Ham"};

    private final double SEAFOOD_PRICE = 17.99;
    private final String[] SEAFOOD_TOPPINGS = {"Shrimp", "Squid", "Crab Meats"};

    private final double PEPPERONI_PRICE = 10.99;
    private final String[] PEPPERONI_TOPPINGS = {"Pepperoni"};

    private final double HAWAIIAN_PRICE = 15.99;
    private final String[] HAWAIIAN_TOPPINGS = {"Pineapple", "Ham"};

    private final double MARGHERITA_PRICE = 13.99;
    private final String[] MARGHERITA_TOPPINGS = {"Basil"};

    private final double VEGGIE_PRICE = 15.99;
    private final String[] VEGGIE_TOPPINGS = {"Black Olive", "Green Pepper", "Onion", "Mushroom"};

    private final double EVIL_PRICE = 29.99;
    private final String[] EVIL_TOPPINGS = {"Sardines", "Pineapple"};

    private final double CHEESE_STEAK_PRICE = 16.99;
    private final String[] CHEESE_STEAK_TOPPINGS = {"Beef", "Green Pepper", "Onion", "Mushroom"};


    private double getSizePrice(){
        if(small.isChecked()){
            return 0.0;
        } else if (medium.isChecked()){
            return 2.0;
        } else return 4.0;
    }
    private double getExtraCost(){
        double extra = 0;
        if(xcheese.isChecked()) extra++;
        if(xsauce.isChecked()) extra++;
        return extra;
    }
    private void updatePrice(String p){
        DecimalFormat priceFormat = new DecimalFormat(".00");
        double price = 0;
        switch(p){
            case "Deluxe":
                price = DELUXE_PRICE;
                break;
            case "Supreme":
                price = SUPREME_PRICE;
                break;
            case "Meatzza":
                price = MEATZZA_PRICE;
                break;
            case "Seafood":
                price = SEAFOOD_PRICE;
                break;
            case "Pepperoni":
                price = PEPPERONI_PRICE;
                break;
            case "Hawaiian":
                price = HAWAIIAN_PRICE;
                break;
            case "Margherita":
                price = MARGHERITA_PRICE;
                break;
            case "Veggie":
                price = VEGGIE_PRICE;
                break;
            case "Evil":
                price = EVIL_PRICE;
                break;
            case "Cheese Steak":
                price = CHEESE_STEAK_PRICE;
                break;
            default:
                return;
        }
        price+=getSizePrice();
        price+=getExtraCost();
        priceText.setText(priceFormat.format(price));
    }

    public void update(){
        String pizzaType = spinner.getSelectedItem().toString();
        switch (pizzaType) {
            case "Deluxe":
                pizzaImage.setImageResource(R.drawable.deluxe);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, DELUXE_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Supreme":
                pizzaImage.setImageResource(R.drawable.supreme);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, SUPREME_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Meatzza":
                pizzaImage.setImageResource(R.drawable.meatzza);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, MEATZZA_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Seafood":
                pizzaImage.setImageResource(R.drawable.seafood);
                sauce.setText("Alfredo");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, SEAFOOD_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Pepperoni":
                pizzaImage.setImageResource(R.drawable.pepperoni);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, PEPPERONI_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Hawaiian":
                pizzaImage.setImageResource(R.drawable.hawaiian);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, HAWAIIAN_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Margherita":
                pizzaImage.setImageResource(R.drawable.margherita);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, MARGHERITA_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Veggie":
                pizzaImage.setImageResource(R.drawable.veggie);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, VEGGIE_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Evil":
                pizzaImage.setImageResource(R.drawable.evil);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, EVIL_TOPPINGS);
                listview.setAdapter(items);
                break;
            case "Cheese Steak":
                pizzaImage.setImageResource(R.drawable.cheesesteak);
                sauce.setText("Tomato");
                updatePrice(pizzaType);
                list.clear();
                Collections.addAll(list, CHEESE_STEAK_TOPPINGS);
                listview.setAdapter(items);
                break;
            default:
                return;
        }

    }

    public void orderPress(View view){
        Pizza newPizza;
        String pizzatype = spinner.getSelectedItem().toString();
        newPizza = PizzaMaker.createPizza(pizzatype, getSize(), xsauce.isChecked(), xcheese.isChecked());
        StoreOrders.getInstance().addPizza(newPizza);

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Adding pizza to order!", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);

        View.OnClickListener updater = v -> update();

        pizzaImage = findViewById(R.id.imageView);

        small = findViewById(R.id.radioButton);
        small.setOnClickListener(updater);
        medium = findViewById(R.id.radioButton2);
        medium.setOnClickListener(updater);
        large = findViewById(R.id.radioButton3);
        large.setOnClickListener(updater);

        xcheese = findViewById(R.id.xcheese);
        xcheese.setOnClickListener(updater);

        xsauce = findViewById(R.id.xsauce);
        xsauce.setOnClickListener(updater);

        sauce = findViewById(R.id.sauce);
        priceText = findViewById(R.id.priceText);

        listview = findViewById(R.id.listView);
        Collections.addAll(list, DELUXE_TOPPINGS);
        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(items);

        spinner = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pizzas);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        update();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
