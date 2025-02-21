package WorkingWithAbstraction.CardSuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");

        Suit[] suits = Suit.values();

        for (Suit suit : suits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
