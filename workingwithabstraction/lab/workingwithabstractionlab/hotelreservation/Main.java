package workingwithabstraction.lab.workingwithabstractionlab.hotelreservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        int multiplier = checkSeason(input[2]).getMultiplier();
        double discount = checkDiscount(input[3]).getDiscount();

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays,multiplier,discount);

        System.out.printf("%.2f%n", calculator.calculate());
    }

    private static Discount checkDiscount(String s) {
        Discount discount = null;

        switch (s){
            case "VIP" -> discount = Discount.VIP;
            case "SecondVisit" -> discount = Discount.SECOND_VISIT;
            case "None" -> discount = Discount.NONE;
        }

        return discount;
    }

    private static Season checkSeason(String s) {
        Season season = null;

        switch (s){
            case "Spring" -> season = Season.SPRING;
            case "Summer" -> season = Season.SUMMER;
            case "Autumn" -> season = Season.AUTUMN;
            case "Winter" -> season = Season.WINTER;
        }

        return season;
    }
}
