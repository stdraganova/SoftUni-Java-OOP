package Encapsulation.exercise.shoppingspree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String[] firstLine = scanner.nextLine().split(";");

        for (String token : firstLine){
            String name = token.split("=")[0];
            double money = Double.parseDouble(token.split("=")[1]);

            Person person = new Person(name, money);
            people.add(person);
        }

        List<Product> products = new ArrayList<>();

        String[] secondLine = scanner.nextLine().split(";");

        for (String token : secondLine){
            String name = token.split("=")[0];
            double cost = Double.parseDouble(token.split("=")[1]);

            Product product = new Product(name, cost);
            products.add(product);
        }

        String[] command = scanner.nextLine().split("\\s+");

        while (!command[0].equals("END")) {

            String personName = command[0];
            String productName = command[1];

            Person person = people.stream().filter(person1 -> person1.getName().equals(personName)).findFirst().orElse(null);
            Product product = products.stream().filter(product1 -> product1.getName().equals(productName)).findFirst().orElse(null);

            if (person != null && product != null) {
                person.buyProduct(product);
            }

            command = scanner.nextLine().split("\\s+");
        }

        for (Person person : people){
            List<Product> personsList = person.getProducts();

            if (personsList.isEmpty()){
                System.out.printf("%s - Nothing bought%n", person.getName());
                continue;
            }

            if (!personsList.isEmpty()) {
                String productNames = personsList.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "));
                System.out.printf("%s - %s%n", person.getName(), productNames);
            }
        }
    }
}
