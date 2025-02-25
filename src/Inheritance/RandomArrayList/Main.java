package Inheritance.RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomList = new RandomArrayList();
        randomList.add("Apple");
        randomList.add("Banana");
        randomList.add("Cherry");
        randomList.add("Date");
        randomList.add(42);

        System.out.println(randomList.getRandomElement());
        System.out.println(randomList.getRandomElement());
    }
}
