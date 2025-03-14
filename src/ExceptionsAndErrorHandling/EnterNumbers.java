package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerRange = 1;
        int upperRange = 100;
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() != 10){
            try {
                int n = readNumber(lowerRange, upperRange, scanner);
                numbers.add(n);
                lowerRange = n;
            }catch (IllegalArgumentException msg){
                System.out.println(msg.getMessage());
            }
        }
        System.out.println(
                String.join(", ", numbers.stream()
                .map(String::valueOf)
                .toArray(String[]::new)));
    }

    private static int readNumber(int lowerRange, int upperRange, Scanner scanner) {
        try {
            int n = Integer.parseInt(scanner.nextLine());
            if (n <= lowerRange || n >= upperRange){
                throw new IllegalArgumentException(String.format("Your number is not in range %d - 100!", lowerRange));
            }
            return n;
        }catch (NumberFormatException msg){
            throw new IllegalArgumentException("Invalid Number!");
        }
    }
}
