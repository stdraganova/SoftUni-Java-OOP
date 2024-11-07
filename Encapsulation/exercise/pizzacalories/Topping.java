package Encapsulation.exercise.pizzacalories;

import java.util.Arrays;
import java.util.List;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        List<String> validToppings = Arrays.asList("Meat", "Veggies", "Cheese", "Sauce");
        if (!validToppings.contains(toppingType)) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }


    private void setWeight(double weight) {
        if (weight < 1 || weight > 50){
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;

        switch (this.toppingType) {
            case "Meat":
                calories *= ToppingsModifiers.MEAT.getModifiers();
                break;
            case "Veggies":
                calories *= ToppingsModifiers.VEGGIES.getModifiers();
                break;
            case "Cheese":
                calories *= ToppingsModifiers.CHEESE.getModifiers();
                break;
            case "Sauce":
                calories *= ToppingsModifiers.SAUCE.getModifiers();
                break;
        }

        return calories;
    }

}
