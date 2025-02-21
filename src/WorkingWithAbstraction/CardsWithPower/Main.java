package WorkingWithAbstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rank rank = Rank.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %S; Card power: %d", rank, suit, rank.getMultiplier() + suit.getPower());
    }
}
