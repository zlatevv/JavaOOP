package SOLID.products.Drink;

public class Coke implements Drink{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * milliliters;
    }

    @Override
    public double getKilograms() {
        return (milliliters / 1000) * DENSITY;
    }
}
