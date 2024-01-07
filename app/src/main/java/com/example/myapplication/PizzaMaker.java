package com.example.myapplication;
/**
 * @author Jason Abahazy
 * @author Kyle Perry
 */

import java.util.ArrayList;

/** Factory class for creating Pizza objects */
public class PizzaMaker {
    /** General handler for creating specialty pizzas */
    public static Pizza createPizza(String pizzaType, Size size, boolean extraSauce, boolean extraCheese) {
        // Use a switch or if-else statements to determine the pizza type
        // and create an instance accordingly using only the Pizza class as the data type
        switch (pizzaType.toLowerCase()) {
            case "deluxe":
                return createDeluxePizza(size, extraSauce, extraCheese);
            case "supreme":
                return createSupremePizza(size, extraSauce, extraCheese);
            case "meatzza":
                return createMeatzzaPizza(size, extraSauce, extraCheese);
            case "seafood":
                return createSeafoodPizza(size, extraSauce, extraCheese);
            case "pepperoni":
                return createPepperoniPizza(size, extraSauce, extraCheese);
            case "hawaiian":
                return createHawaiianPizza(size, extraSauce, extraCheese);
            case "margherita":
                return createMargheritaPizza(size, extraSauce, extraCheese);
            case "veggie":
                return createVeggiePizza(size, extraSauce, extraCheese);
            case "evil":
                return createEvilPizza(size, extraSauce, extraCheese);
            case "cheese steak":
                return createCheeseSteakPizza(size, extraSauce, extraCheese);
            default:
                throw new IllegalArgumentException("Invalid pizza type: " + pizzaType);
        }
    }

    private static Pizza createCheeseSteakPizza(Size size, boolean extraSauce, boolean extraCheese) {
        return new CheeseSteakPizza(size, extraSauce, extraCheese);
    }

    private static Pizza createEvilPizza(Size size, boolean extraSauce, boolean extraCheese) {
        return new EvilPizza(size, extraSauce, extraCheese);
    }

    private static Pizza createVeggiePizza(Size size, boolean extraSauce, boolean extraCheese) {
        return new VeggiePizza(size, extraSauce, extraCheese);
    }

    private static Pizza createMargheritaPizza(Size size, boolean extraSauce, boolean extraCheese) {
        return new MargheritaPizza(size, extraSauce, extraCheese);
    }

    private static Pizza createHawaiianPizza(Size size, boolean extraSauce, boolean extraCheese) {
        return new HawaiianPizza(size, extraSauce, extraCheese);
    }

    /** Method creates a Deluxe Pizza */
    private static Pizza createDeluxePizza(Size size, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a DeluxePizza instance using only the Pizza class as the data type
        // You can use the Pizza constructor with appropriate parameters
        return new DeluxePizza(size, extraSauce, extraCheese);
    }

    /** Method creates a Supreme Pizza */
    private static Pizza createSupremePizza(Size size, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a SupremePizza instance using only the Pizza class as the data type
        return new SupremePizza(size, extraSauce, extraCheese);
    }

    /** Method creates a Meatzza Pizza */
    private static Pizza createMeatzzaPizza(Size size, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a MeatzzaPizza instance using only the Pizza class as the data type
        return new MeatzzaPizza(size, extraSauce, extraCheese);
    }

    /** Method creates a Seafood Pizza */
    private static Pizza createSeafoodPizza(Size size, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a SeafoodPizza instance using only the Pizza class as the data type
        return new SeafoodPizza(size, extraSauce, extraCheese);
    }

    /** Method creates a Pepperoni Pizza */
    private static Pizza createPepperoniPizza(Size size, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a PepperoniPizza instance using only the Pizza class as the data type
        return new PepperoniPizza(size, extraSauce, extraCheese);
    }

    /** Method for handling the creation of custom Pizzas */
    public static Pizza createBuildYourOwnPizza(ArrayList<Topping> toppings, Size size, Sauce sauce, boolean extraSauce, boolean extraCheese) {
        // Add logic to create a BuildYourOwnPizza instance using only the Pizza class as the data type
        return new BuildYourOwnPizza(size, sauce, extraSauce, extraCheese, toppings);
    }
}