package interfacesandabstraction.exercise.defineaninterfaceperson.telephony;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::new).toList();

        List<String> urls = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(String::new).toList();

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
