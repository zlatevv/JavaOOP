package ExamPrep.competition.entities.destination;

import ExamPrep.competition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPrep.competition.common.ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY;
import static ExamPrep.competition.common.ExceptionMessages.NEGATIVE_DISTANCE_VALUE;

public class BaseDestination implements Destination{
    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        setName(name);
        setDistance(distance);
        this.cars = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setDistance(int distance) {
        if (distance <= 0){
            //TODO check if <= 0 is the problem if you don't get 50 points
            throw new IllegalArgumentException(NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }

    @Override
    public Collection<Car> getCars() {
        return this.cars;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
    public void addCar(Car car){
        this.cars.add(car);
    }
}
