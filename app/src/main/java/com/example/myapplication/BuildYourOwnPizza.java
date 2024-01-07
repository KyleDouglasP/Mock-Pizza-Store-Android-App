package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import java.text.DecimalFormat;
import java.util.ArrayList;

/** Class extends Pizza, defining custom made pizzas */
public class BuildYourOwnPizza extends Pizza {
    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = SMALL_PRICE + 2.0;
    private static final double LARGE_PRICE = SMALL_PRICE + 4.0;
    private static final double TOPPING_PRICE = 1.49;

    private int toppingCount;

    /** Constructor */
    public BuildYourOwnPizza(Size size, Sauce sauce, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings) {
        super(size, sauce, extraSauce, extraCheese);
        this.toppings=toppings;
        this.toppingCount = toppings.size();
    }

    /** Overridden toString() method */
    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat(".00");
        return "[Build Your Own] " + super.toString() + "$" + priceFormat.format(price());
    }

    /** Overridden price() method */
    @Override
    public double price() {
        double basePrice;
        double extraCheesePrice = 0;
        double extraSaucePrice = 0;

        switch (size) {
            case SMALL:
                basePrice = SMALL_PRICE;
                break;
            case MEDIUM:
                basePrice = MEDIUM_PRICE;
                break;
            case LARGE:
                basePrice = LARGE_PRICE;
                break;
            default:
                throw new IllegalArgumentException("Invalid pizza size");
        }

        if(getExtraCheese()){
            extraCheesePrice = 1;
        }

        if(getExtraSauce()){
            extraSaucePrice = 1;
        }

        double toppingPrice = (toppingCount - 3) * TOPPING_PRICE;
        return basePrice + Math.max(0, toppingPrice) + extraCheesePrice + extraSaucePrice;
    }
}
