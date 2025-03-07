package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carDetails = scanner.nextLine().split("\\s+");
        String[] truckDetails = scanner.nextLine().split("\\s+");
        String[] busDetails = scanner.nextLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carDetails[1]);
        double carFuelConsumption = Double.parseDouble(carDetails[2]);
        double carTankCapacity = Double.parseDouble(carDetails[3]);

        double truckFuelQuantity = Double.parseDouble(truckDetails[1]);
        double truckFuelConsumption = Double.parseDouble(truckDetails[2]);
        double truckTankCapacity = Double.parseDouble(truckDetails[3]);

        double busFuelQuantity = Double.parseDouble(busDetails[1]);
        double busFuelConsumption = Double.parseDouble(busDetails[2]);
        double busTankCapacity = Double.parseDouble(busDetails[3]);

        Car car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);
        Bus bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);

        int countCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCommand; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandName = commandParts[0];
            String vehicleType = commandParts[1];
            double fuelQuantityOrDistance = Double.parseDouble(commandParts[2]);

            switch (commandName) {
                case "Drive" -> {
                    switch (vehicleType) {
                        case "Car" -> System.out.println(car.drive(fuelQuantityOrDistance));
                        case "Truck" -> System.out.println(truck.drive(fuelQuantityOrDistance));
                        case "Bus" -> System.out.println(bus.drive(fuelQuantityOrDistance));
                    }
                }
                case "DriveEmpty" -> System.out.println(bus.driveEmptyBus(fuelQuantityOrDistance));

                case "Refuel" -> {
                    switch (vehicleType) {
                        case "Car" -> car.refuel(fuelQuantityOrDistance);
                        case "Truck" -> truck.refuel(fuelQuantityOrDistance);
                        case "Bus" -> bus.refuel(fuelQuantityOrDistance);
                    }
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
