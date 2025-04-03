package ExamPrep.competition.entities.destination;

import ExamPrep.competition.entities.car.Car;

import java.util.Collection;

public interface Destination {

    Collection<Car> getCars();

    String getName();

    int getDistance();
}
