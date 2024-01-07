package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/** Singleton class to handle multiple orders */
public class StoreOrders {
    private static StoreOrders instance = new StoreOrders();

    public static StoreOrders getInstance(){
        if(instance==null){
            instance = new StoreOrders();
        }
        return instance;
    }
    private static int nextOrderNumber = 1;
    private Order currentOrder = new Order();
    public Order getCurrentOrder(){
        return currentOrder;
    }
    public void addPizza(Pizza pizza){
        currentOrder.addPizza(pizza);
    }
    public void removePizza(int index){
        currentOrder.removePizza(index);
    }
    public void placeCurrentOrder(){
        placeOrder(currentOrder);
        currentOrder = new Order();
    }
    /** Getter method for next available order number */
    public int getOrderNumber(){
        return nextOrderNumber;
    }
    private ArrayList<Order> orders;
    /** Getter method for ArrayList of orders */
    public ArrayList<Order> getOrders(){
        return orders;
    }

    /** Default constructor */
    private StoreOrders() {
        this.orders = new ArrayList<>();
    }

    /** Getter method for the number of orders */
    public int getNumberofOrders(){
        return orders.size();
    }

    /** Getter method for an order based on its order number */
    public Order getOrder(int orderNumber){
        for(Order order : orders){
            if(order.getOrderNumber()==orderNumber){
                return order;
            }
        }
        return null;
    }

    /** Method to place an order */
    public Order placeOrder(Order order) {
        order.setOrderNumber(nextOrderNumber++);
        orders.add(order);
        return order;
    }

    /** Method to cancel an order based on its order number */
    public Order cancelOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    /** Method to export all the orders as a .txt file */
    public void export(File txtfile) throws FileNotFoundException {

        DecimalFormat priceFormat = new DecimalFormat(".00");
        double price;
        PrintWriter pw = new PrintWriter(txtfile);
        for(Order order : orders){
            price = 0;
            pw.println("Order Number: " + order.getOrderNumber());
            for(Pizza pizza : order.getPizzas()){
                pw.println(pizza.toString());
                price+= pizza.price();
            }
            pw.println("Total cost: $" + priceFormat.format(price*1.06625));
            pw.println();
        }
        pw.close();

    }
}