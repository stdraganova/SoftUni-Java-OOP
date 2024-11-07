package exceptionsanderrorhandling;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isValidNumber = false;
        int number = 0;

        double result = 0;
        try {
            number = Integer.parseInt(input);
            isValidNumber = number > 0;

            result = Math.sqrt(number);

        } catch (NumberFormatException e) {
        }

        if (!isValidNumber){
            System.out.println("Invalid");
        }else {
            System.out.printf("%.2f%n", result);
        }

        System.out.println("Goodbye");
    }
}
