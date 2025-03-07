package Polymorphism.Vehicles;

public class Truck extends Vehicle{


    public Truck(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
        this.fuelConsumption = fuelConsumption + 1.6;
    }

    @Override
    public String drive(double distance) {
        return super.drive(distance);
    }

    @Override
    public void refuel(double refuel) {
        refuel = refuel * 0.95;
        super.refuel(refuel);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
