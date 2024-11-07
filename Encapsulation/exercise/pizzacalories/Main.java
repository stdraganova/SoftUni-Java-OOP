package Encapsulation.exercise.pizzacalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String pizzaName = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);

        String[] doughInformation = scanner.nextLine().split("\\s+");
        String flourType = doughInformation[1];
        String backingTechnique = doughInformation[2];
        double weightOfDough = Double.parseDouble(doughInformation[3]);

        Dough dough = new Dough(flourType, backingTechnique, weightOfDough);
        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        pizza.setDough(dough);

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("END")){

            String toppingType = input[1];
            double weightOfTopping = Double.parseDouble(input[2]);

            Topping topping = new Topping(toppingType, weightOfTopping);
            pizza.addTopping(topping);

            input = scanner.nextLine().split("\\s+");
        }

        printPizza(pizza);
    }

    private static void printPizza(Pizza pizza) {
        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}
