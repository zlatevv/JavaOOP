package SOLID.products.Drink;

public class Lemonade implements Drink{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * getMilliliters();
    }

    @Override
    public double getKilograms() {
        return (milliliters / 1000) * DENSITY;
    }
}
