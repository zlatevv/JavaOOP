package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    public Double fuel;
    public Double fuelConsumption;
    public Double tankCapacity;

    public Vehicle(Double fuel, Double fuelConsumption, Double tankCapacity) {
        this.fuel = fuel;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public Double getFuel() {
        return fuel;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }
    public String drive(double distance){
        double neededFuel = distance * fuelConsumption;
        if (neededFuel <= fuel){
            fuel -= neededFuel;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }
    public void refuel(double refuel){
        if (refuel <= 0){
            System.out.println("Fuel must be a positive number");
        }else {
            double availableSpace = tankCapacity - fuel;
            if (availableSpace > refuel){
                fuel += refuel;
            }else{
                System.out.println("Cannot fit fuel in tank");
            }

        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuel);
    }

    public void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
