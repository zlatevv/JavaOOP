package ExamPrep.competition.entities.competition;

import ExamPrep.competition.entities.car.Car;
import ExamPrep.competition.entities.destination.Destination;

import java.util.Collection;

public interface Competition {

    void startVoyage(Destination destination, Collection<Car> cars);
}
