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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class BuildActivity extends AppCompatActivity {

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

    private double getSizePrice(){
        if(small.isChecked()){
            return 0.0;
        } else if (medium.isChecked()){
            return 2.0;
        } else return 4.0;
    }
    private RadioButton tomato;
    private RadioButton alfredo;
    private Sauce getSauce(){
        if(tomato.isChecked()) return Sauce.TOMATO;
        else return Sauce.ALFREDO;
    }

    private CheckBox xSauce;
    private CheckBox xCheese;
    private double getExtraCost(){
        double extra = 0;
        if(xCheese.isChecked()) extra++;
        if(xSauce.isChecked()) extra++;
        return extra;
    }
    private ImageView customPizza;
    private TextView priceText;
    private ListView availableToppings;
    private ObservableArrayList<String> availableList = new ObservableArrayList<>();
    private ArrayAdapter<String> availableAdapter;
    private ListView selectedToppings;
    private ObservableArrayList<String> selectedList = new ObservableArrayList<>();
    private ArrayAdapter<String> selectedAdapter;

    private void updatePrice(){
        availableToppings.setAdapter(availableAdapter);
        selectedToppings.setAdapter(selectedAdapter);

        double newPrice = 8.99;
        newPrice+=getSizePrice();
        newPrice+=getExtraCost();

        if(selectedToppings.getCount()>3){
            newPrice+=((selectedToppings.getCount()-3)*1.49);
        }

        DecimalFormat priceFormat = new DecimalFormat(".00");
        priceText.setText(priceFormat.format(newPrice));
    }

    public void onAddPress(View view){
        if(availableToppings.getCheckedItemPosition() == AdapterView.INVALID_POSITION){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please select a topping to add!").setTitle("Invalid Selection");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        if(selectedToppings.getCount()==7){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("No more than 7 toppings allowed!").setTitle("Too many toppings");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        int index = availableToppings.getCheckedItemPosition();
        selectedList.add(availableList.get(index));
        availableList.remove(index);
        updatePrice();
    }

    public void onRemovePress(View view){
        if(selectedToppings.getCheckedItemPosition() == AdapterView.INVALID_POSITION){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please select a topping to remove!").setTitle("Invalid Selection");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        int index = selectedToppings.getCheckedItemPosition();
        availableList.add(selectedList.get(index));
        selectedList.remove(index);
        updatePrice();
    }

    public void onOrderPress(View view){
        Pizza newPizza;
        ArrayList<Topping> newPizzaToppings = new ArrayList<>();
        for(String topping: selectedList){
            newPizzaToppings.add(Topping.valueOf(topping));
        }
        newPizza = PizzaMaker.createBuildYourOwnPizza(newPizzaToppings, getSize(), getSauce(), xSauce.isChecked(), xCheese.isChecked());
        StoreOrders.getInstance().addPizza(newPizza);

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Adding pizza to order!", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        View.OnClickListener updater = v -> updatePrice();

        customPizza = findViewById(R.id.imageView);
        customPizza.setImageResource(R.drawable.custompizza);

        small = findViewById(R.id.radioButton4);
        small.setOnClickListener(updater);
        medium = findViewById(R.id.radioButton5);
        medium.setOnClickListener(updater);
        large = findViewById(R.id.radioButton6);
        large.setOnClickListener(updater);

        tomato = findViewById(R.id.radioButton9);
        tomato.setOnClickListener(updater);
        alfredo = findViewById(R.id.radioButton10);
        alfredo.setOnClickListener(updater);

        xCheese = findViewById(R.id.xcheese);
        xCheese.setOnClickListener(updater);

        xSauce = findViewById(R.id.xsauce);
        xSauce.setOnClickListener(updater);

        priceText = findViewById(R.id.textView8);

        String[] toppings = new String[Topping.values().length];
        int counter = 0;
        for(Topping topping: Topping.values()){
            toppings[counter++] = topping.toString();
        }
        Collections.addAll(availableList, toppings);
        availableToppings = findViewById(R.id.availableToppings);
        availableAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, availableList);
        availableToppings.setAdapter(availableAdapter);

        selectedToppings = findViewById(R.id.selectedToppings);
        selectedAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, selectedList);
        selectedToppings.setAdapter(selectedAdapter);

        updatePrice();

    }
}
