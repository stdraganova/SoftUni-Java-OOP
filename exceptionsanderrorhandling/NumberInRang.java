package exceptionsanderrorhandling;

import java.util.Scanner;

public class NumberInRang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int begin = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]%n", begin, end);

        boolean isValidNumber = false;
        int number = 0;

        while (!isValidNumber) {
            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);
                isValidNumber = number >= begin && number <= end;

            } catch (NumberFormatException e) {
            }

            if (!isValidNumber) {
                System.out.println("Invalid number: " + input);
            }
        }

        System.out.println("Valid number: " + number);
    }
}
