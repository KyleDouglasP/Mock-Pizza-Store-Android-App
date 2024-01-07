package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Kyle Perry
 */
public class StoreActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner orderSelector;
    private ObservableArrayList<String> orderList = new ObservableArrayList<>();
    private ArrayAdapter<String> adapter;
    private TextView total;
    private ListView orderPizzas;
    private ObservableArrayList<String> pizzaList = new ObservableArrayList<>();
    private ArrayAdapter<String> adapter2;

    private void populateOrders(){
        orderList.clear();
        orderSelector.setAdapter(adapter);
        total.setText("");
        if(StoreOrders.getInstance().getNumberofOrders()==0) return;
        for(Order order: StoreOrders.getInstance().getOrders()){
            orderList.add(order.getOrderNumber()+"");
        }
        orderSelector.setAdapter(adapter);
        populatePizzas();
    }

    private void populatePizzas(){
        pizzaList.clear();
        orderPizzas.setAdapter(adapter2);
        total.setText("");
        if(orderSelector.getSelectedItem()==null) return;
        int selectedOrderNumber = Integer.parseInt(orderSelector.getSelectedItem().toString());
        Order selectedOrder = StoreOrders.getInstance().getOrder(selectedOrderNumber);

        ArrayList<String> pizzaStrings = new ArrayList<>();
        double subtotalAmount = 0;
        for(Pizza pizza: selectedOrder.getPizzas()){
            pizzaStrings.add(pizza.toString());
            subtotalAmount+=pizza.price();
        }

        String[] pizzaStrings2 = new String[pizzaStrings.size()];
        for(int i=0; i<pizzaStrings2.length; i++){
            pizzaStrings2[i]=pizzaStrings.get(i);
        }

        Collections.addAll(pizzaList, pizzaStrings2);
        orderPizzas.setAdapter(adapter2);
        DecimalFormat priceFormat = new DecimalFormat(".00");
        total.setText(priceFormat.format(subtotalAmount*1.06625));
    }

    public void onCancelOrder(View view){
        if (orderSelector.getSelectedItem() == null){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Please select an order to cancel").setTitle("Invalid Selection");
            AlertDialog dialog = alert.create();
            dialog.show();
            return;
        }
        int orderNumber = Integer.parseInt(orderSelector.getSelectedItem().toString());
        StoreOrders.getInstance().cancelOrder(orderNumber);
        populateOrders();
        populatePizzas();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        total = findViewById(R.id.total2);

        orderSelector = findViewById(R.id.ordernumberselector);
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, orderList);
        orderSelector.setAdapter(adapter);

        orderSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                populatePizzas();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        orderPizzas = findViewById(R.id.orderpizzalist);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList);
        orderPizzas.setAdapter(adapter2);

        populateOrders();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        populatePizzas();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
