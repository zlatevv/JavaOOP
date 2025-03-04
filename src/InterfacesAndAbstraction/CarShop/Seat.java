package InterfacesAndAbstraction.CarShop;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsepower, String countryProduced, Double price) {
        super(model, color, horsepower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
