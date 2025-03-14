package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try{
            int n = Integer.parseInt(input);
            if (n < 1){
                throw new IllegalArgumentException();
            }
            System.out.printf("%.2f%n", Math.sqrt(n));
        }catch (IllegalArgumentException e){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }
}
