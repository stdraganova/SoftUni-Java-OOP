package Encapsulation.exercise.pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsSize) {
        this.setName(name);
        this.setToppings(toppingsSize);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.trim().length() > 15) {
            throw new IllegalArgumentException("Encapsulation.exercise.pizzacalories.Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name.trim();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }


    private void setToppings(int toppingsSize) {
        if (toppingsSize < 0 || toppingsSize > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppingsSize);
    }

    public String getName() {
        return this.name;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories () {
        double totalCalories = this.dough.calculateCalories();

        for (Topping topping : toppings){
            totalCalories += topping.calculateCalories();
        }

        return totalCalories;
    }
}
