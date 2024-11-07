package workingwithabstraction.lab.exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix);

        long totalStarsCount = 0;

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] jedi = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evil[0];
            int evilCol = evil[1];

            moveEvilPlayer(matrix, evilCol, evilRow);

            int jediRow = jedi[0];
            int jediCol = jedi[1];

           totalStarsCount = moveJediAndCountStars(matrix, jediRow, jediCol);

            command = scanner.nextLine();
        }

        System.out.println(totalStarsCount);
    }

    private static int moveJediAndCountStars(int[][] matrix, int jediRow, int jediCol) {
        int totalStarsCount = 0;
        while (jediRow >= 0 && jediCol < matrix[1].length) {
            if (jediRow < matrix.length && jediCol >= 0 && jediCol < matrix[0].length) {
                totalStarsCount += matrix[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }

        return totalStarsCount;
    }

    private static void moveEvilPlayer(int[][] matrix, int evilCol, int evilRow) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillMatrix(int[][] matrix) {

        int value = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}
