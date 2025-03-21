package ExamPrep.competition.entities.competition;

import ExamPrep.competition.entities.car.Car;
import ExamPrep.competition.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition{
    public CompetitionImpl() {
    }

    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        for (Car car : cars) {
            while (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() >= 15){
                car.drive();
            }
        }
    }
}
