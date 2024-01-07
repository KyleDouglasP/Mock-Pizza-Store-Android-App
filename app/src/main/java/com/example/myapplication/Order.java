package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import java.util.ArrayList;

/** Class defines a singular order, containing pizzas */
public class Order {
    private int orderNumber;

    /** Setter method for the order number */
    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    /** Getter method for the order number */
    public int getOrderNumber(){
        return orderNumber;
    }
    private ArrayList<Pizza> pizzas;

    /** Getter method for the pizzas */
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }

    /** Default constructor */
    public Order() {
        this.pizzas = new ArrayList<>();
    }

    /** Method to add a pizza to the order */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /** Method to remove a pizza from the order */
    public void removePizza(int index){
        pizzas.remove(index);
    }

    // Other methods as needed
}
