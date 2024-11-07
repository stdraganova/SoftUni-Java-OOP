package interfacesandabstraction.lab.bordercontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String[] tokens = scanner.nextLine().split("\\s+");

        while (!tokens[0].equals("End")) {
            if (tokens.length == 2) {

                String model = tokens[0];
                String id = tokens[1];

                Identifiable identifiable = new Robot(model, id);
                identifiables.add(identifiable);

            } else {

                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Identifiable identifiable = new Citizen(name, age, id);
                identifiables.add(identifiable);
            }

            tokens = scanner.nextLine().split("\\s+");
        }

        String suffix = scanner.nextLine();

        identifiables.stream().filter(identifiable -> identifiable.getId().endsWith(suffix))
                .forEach(identifiable -> System.out.println(identifiable.getId()));
    }
}
