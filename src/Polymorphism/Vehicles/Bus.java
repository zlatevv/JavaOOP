package Polymorphism.Vehicles;

public class Bus extends Vehicle{
    public Bus(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        this.setFuelConsumption(getFuelConsumption() + 1.4);
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
    public String driveEmptyBus(double distance){
        return super.drive(distance);
    }
}
