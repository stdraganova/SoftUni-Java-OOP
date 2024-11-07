package polymorphism.lab.wildfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Mammal> animals = new ArrayList<>();

        int countLines = 1;

        String[] input = scanner.nextLine().split("\\s+");
        Food food = null;
        Mammal mammal = null;

        while (!input[0].equals("End")) {

            if (countLines % 2 != 0) {

                String animalType = input[0];
                String name = input[1];
                Double weight = Double.parseDouble(input[2]);
                String livingRegion = input[3];

                switch (animalType) {
                    case "Cat" -> {
                        String breed = input[4];
                        mammal = new Cat(name, animalType, weight, livingRegion, breed);
                    }
                    case "Tiger" -> {
                        mammal = new Tiger(name, animalType,weight,livingRegion);
                    }
                    case "Zebra" -> {
                        mammal = new Zebra(name, animalType,weight,livingRegion);
                    }
                    case "Mouse" -> {
                        mammal = new Mouse(name, animalType,weight,livingRegion);
                    }
                }

            }else {
                String foodType = input[0];
                Integer quantity = Integer.parseInt(input[1]);

                switch (foodType){
                    case "Vegetable" -> {
                        food = new Vegetable(quantity);
                    }
                    case "Meat" -> {
                        food = new Meat(quantity);
                    }
                }

                mammal.makeSound();
                mammal.eat(food);
            }

            countLines++;
            input = scanner.nextLine().split("\\s+");
        }
    }
}
