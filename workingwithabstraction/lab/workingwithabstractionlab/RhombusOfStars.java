package workingwithabstraction.lab.workingwithabstractionlab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printUpperPatr(n);
        printLowerPart(n);
    }

    private static void printLowerPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            for (int i = n - row; i < n; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < n- row; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printUpperPatr(int n) {
        for (int row = 1; row <= n; row++) {
            for (int i = 0; i < n - row; i++) {
                System.out.print(" ");
            }
            for (int i = n - row; i < n; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
