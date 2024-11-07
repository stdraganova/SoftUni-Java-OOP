package inheritance.exercise.person.animals;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("Beast!")){
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (age < 0){
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            switch (command){
                case "Cat" -> {
                    String gender = input[2];
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                }
                case "Dog" -> {
                    String gender = input[2];
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                }
                case "Frog" -> {
                    String gender = input[2];
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                }
                case "Kitten" -> {
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                }
                case "Tomcat" -> {
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                }

            }

            command = scanner.nextLine();
        }
    }
}
