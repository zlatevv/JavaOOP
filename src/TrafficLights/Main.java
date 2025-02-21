package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Lights::valueOf)
                .toArray(Lights[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            switchLights(lights);
            printLights(lights);
        }
    }

    private static void switchLights(Lights[] lights) {
        for (int i = 0; i < lights.length; i++) {
            switch (lights[i]){
                case GREEN -> lights[i] = Lights.YELLOW;
                case YELLOW -> lights[i] = Lights.RED;
                case RED -> lights[i] = Lights.GREEN;
            }
        }
    }

    private static void printLights(Lights[] lights) {
        for (Lights light : lights) {
            System.out.print(light + " ");
        }
        System.out.println();
    }
}
