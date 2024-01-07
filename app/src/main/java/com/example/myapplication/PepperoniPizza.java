package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import java.text.DecimalFormat;

/** Extends Pizza class to define a Pepperoni Pizza */
public class PepperoniPizza extends Pizza {

    /** Constructor */
    public PepperoniPizza(Size size, boolean extraSauce, boolean extraCheese) {
        super(size, Sauce.TOMATO, extraSauce, extraCheese);
        toppings.add(Topping.PEPPERONI);
    }

    /** Overridden toString() method */
    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat(".00");
        return "[Pepperoni] " + super.toString() + "$" + priceFormat.format(price());
    }

    /** Overridden price() method */
    @Override
    public double price() {
        double basePrice = 10.99; // base price for small size
        double sizePrice = 0; // additional price based on size

        double extraCheesePrice = 0;
        double extraSaucePrice = 0;

        Size pizzaSize = getSize();
        
        if (pizzaSize.equals(Size.MEDIUM)) {
            sizePrice = 2.00;
        } else if (pizzaSize.equals(Size.LARGE)) {
            sizePrice = 4.00;
        }

        if(getExtraCheese()){
            extraCheesePrice = 1;
        }

        if(getExtraSauce()){
            extraSaucePrice = 1;
        }
    
        return basePrice + sizePrice + extraCheesePrice + extraSaucePrice;
}
}
