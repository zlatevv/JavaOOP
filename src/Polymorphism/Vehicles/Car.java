package Polymorphism.Vehicles;

public class Car extends Vehicle{


    public Car(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption + 0.9, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    @Override
    public void refuel(double refuel) {
        super.refuel(refuel);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
