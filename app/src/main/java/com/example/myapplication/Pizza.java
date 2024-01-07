package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import com.example.myapplication.Sauce;
import com.example.myapplication.Size;
import com.example.myapplication.Topping;

import java.util.ArrayList;

/** Abstract class defines a Pizza, to be extended by different types */
public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce;
    protected boolean extraCheese;

    /** Constructor */
    public Pizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = sauce;
        this.extraSauce = extraSauce;
        this.extraCheese = extraCheese;
        toppings = new ArrayList<>();
    }

    /** Returns pizza as a string, with toppings and sauce options */
    public String toString(){
        String temp = "";
        for(Topping topping: toppings){
            temp+=(topping.toString() + ", ");
        }
        temp+=(size.toString()+", ");
        temp+=(sauce.toString()+", ");
        if(extraSauce) temp+="Extra Sauce, ";
        if(extraCheese) temp+="Extra Cheese, ";
        return temp;
    }

    /** Abstract method to return the price of the pizza */
    public abstract double price(); // Polymorphism

    /** Getter method for the size */
    public Size getSize() {
        return size;
    }

    /** Getter method for the extra sauce */
    public boolean getExtraSauce(){
        return extraSauce;
    }

    /** Getter method for the extra cheese */
    public boolean getExtraCheese(){
        return extraCheese;
    }
}