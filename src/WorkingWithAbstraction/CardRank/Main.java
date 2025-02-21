package WorkingWithAbstraction.CardRank;


public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        Rank[] ranks = Rank.values();

        for (Rank suit : ranks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
