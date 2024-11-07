package workingwithabstraction.lab.exercise.trafficlights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TrafficLights[] trafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLights::valueOf).toArray(TrafficLights[]::new);

        int numberOfUpdates = Integer.parseInt(scanner.nextLine());

        for (int update = 0; update < numberOfUpdates; update++) {

            updateTrafficLights(trafficLights);

            printTrafficLights(trafficLights);
        }
    }

    private static void printTrafficLights(TrafficLights[] trafficLights) {
        for (TrafficLights light : trafficLights){
            System.out.print(light + " ");
        }
        System.out.println();
    }

    private static void updateTrafficLights(TrafficLights[] trafficLights) {

        for (int element = 0; element < trafficLights.length; element++) {
            switch (trafficLights[element]){
                case RED -> trafficLights[element] = TrafficLights.GREEN;
                case GREEN -> trafficLights[element] = TrafficLights.YELLOW;
                case YELLOW -> trafficLights[element] = TrafficLights.RED;
            }
        }
    }
}
