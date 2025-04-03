package ExamPrep.competition.core;

//TODO - Implement all the methods

import ExamPrep.competition.entities.car.*;
import ExamPrep.competition.entities.competition.CompetitionImpl;
import ExamPrep.competition.entities.destination.Destination;
import ExamPrep.competition.entities.destination.Lake;
import ExamPrep.competition.entities.destination.Mountain;
import ExamPrep.competition.entities.destination.SeaSide;
import ExamPrep.competition.entities.repositories.DestinationRepository;

import static ExamPrep.competition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DestinationRepository destinationRepository;
    private CompetitionImpl competition;
    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
        this.competition = new CompetitionImpl();
    }

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination destination;
        switch (destinationType){
            case "Lake":
                destination = new Lake(destinationName);
                break;
            case "Mountain":
                destination = new Mountain(destinationName);
                break;
            case "SeaSide":
                destination = new SeaSide(destinationName);
                break;
            default:
                throw new IllegalArgumentException(INVALID_DESTINATION);
        }
        if (destinationRepository.byName(destinationName) != null){
            throw new IllegalArgumentException(EXISTING_DESTINATION);
        }
        this.destinationRepository.add(destination);
        return String.format("Successfully added destination %s %s.", destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        Destination destination = destinationRepository.byName(destinationName);
        if (destination == null){
            throw new NullPointerException(NON_EXISTING_DESTINATION);
        }
        for (Car car : destination.getCars()) {
            if (car.getModel().equals(carModel) && car.getClass().getSimpleName().equals(carBrand)){
                throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL);
            }
        }
        BaseCar car;
        switch (carBrand){
            case "Tesla":
                car = new Tesla(carModel);
                break;
            case "Hyundai":
                car = new Hyundai(carModel);
                break;
            case "VW":
                car = new VW(carModel);
                break;
            case "Dacia":
                car = new Dacia(carModel);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAR);
        }
        destination.getCars().add(car);
        return String.format("Successfully added car %s %s.", carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        Destination destination = destinationRepository.byName(destinationName);
        competition.startVoyage(destination, destination.getCars());
        int droppedCarsCount = 0;
        for (Car car : destination.getCars()) {
            if (car.getMileage() < destination.getDistance()){
                droppedCarsCount++;
            }
        }
        return String.format("The voyage to %s is over. %d cars dropped out of the voyage.",
                destinationName,
                droppedCarsCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Destination destination : destinationRepository.getCollection()) {
            stringBuilder.append(String.format("Cars that took part in ExamPrep.competition to %s:%n", destination.getName()));
            for (Car car : destination.getCars()) {
                stringBuilder.append(String.format("*%s %s%n", car.getClass().getSimpleName(), car.getModel()));
                stringBuilder.append(String.format("**Battery capacity: %dkWh.%n", car.getBatteryCapacity()));
                stringBuilder.append(String.format("**Mileage: %dkm.%n", car.getMileage()));
            }
        }
        return stringBuilder.toString();
    }
}
