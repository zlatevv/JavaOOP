package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printRhombus(size);
    }

    private static void printRhombus(int size) {
        for (int i = 1; i <= size; i++) {
            printRow(i, size);
        }
        for (int i = size - 1; i >= 1; i--) {
            printRow(i, size);
        }
    }

    private static void printRow(int i, int size) {
        for (int j = i; j < size; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
