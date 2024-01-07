package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class CurrentActivity extends AppCompatActivity {

    private TextView ordernum;
    private TextView subtotal;
    private TextView tax;
    private TextView total;

    private ListView pizzas;
    private ObservableArrayList<String> pizzaList = new ObservableArrayList<>();
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        ordernum = findViewById(R.id.ordernum);
        subtotal = findViewById(R.id.subtotal);
        tax = findViewById(R.id.tax);
        total = findViewById(R.id.total2);

        pizzas = findViewById(R.id.listView2);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList);
        pizzas.setAdapter(adapter);

        populate();

    }

    public void onRemovePizza(View view){
        if(pizzas.getCheckedItemPosition() == AdapterView.INVALID_POSITION){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please select a pizza to remove!").setTitle("Invalid Selection");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        int index = pizzas.getCheckedItemPosition();
        StoreOrders.getInstance().removePizza(index);
        populate();
    }
    public void onOrder(View view){
        if(StoreOrders.getInstance().getCurrentOrder().getPizzas().isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please add pizzas to your order!").setTitle("Invalid Order");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        StoreOrders.getInstance().placeCurrentOrder();
        populate();
    }

    private void populate(){
        ordernum.setText(StoreOrders.getInstance().getOrderNumber()+"");
        pizzaList.clear();

        if(StoreOrders.getInstance().getCurrentOrder().getPizzas().isEmpty()){
            pizzas.setAdapter(adapter);
            subtotal.setText("");
            tax.setText("");
            total.setText("");
            return;
        }
        ArrayList<String> pizzaStrings = new ArrayList<>();
        double subtotalAmount = 0;
        for(Pizza pizza: StoreOrders.getInstance().getCurrentOrder().getPizzas()){
            pizzaStrings.add(pizza.toString());
            subtotalAmount+=pizza.price();
        }

        String[] pizzaStrings2 = new String[pizzaStrings.size()];
        for(int i=0; i<pizzaStrings2.length; i++){
            pizzaStrings2[i]=pizzaStrings.get(i);
        }

        Collections.addAll(pizzaList, pizzaStrings2);
        pizzas.setAdapter(adapter);

        DecimalFormat priceFormat = new DecimalFormat(".00");
        subtotal.setText(priceFormat.format(subtotalAmount));
        tax.setText(priceFormat.format(subtotalAmount*.06625));
        total.setText(priceFormat.format(subtotalAmount*1.06625));
    }

}
