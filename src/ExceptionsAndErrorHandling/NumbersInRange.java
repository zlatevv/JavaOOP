package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int lowerIndex = Integer.parseInt(input[0]);
        int upperIndex = Integer.parseInt(input[1]);
        System.out.printf("Range: [%d...%d]%n", lowerIndex, upperIndex);
        while (true){
            String data = scanner.nextLine();
            try {
                int n = Integer.parseInt(data);

                if (n < lowerIndex || n > upperIndex){
                    System.out.printf("Invalid number: %d%n", n);
                }else{
                    System.out.printf("Valid number: %d%n", n);
                    break;
                }
            }catch (IllegalArgumentException msg){
                System.out.printf("Invalid number: %s%n", data);
            }
        }
    }
}
