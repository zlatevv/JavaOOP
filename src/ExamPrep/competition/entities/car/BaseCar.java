package ExamPrep.competition.entities.car;

import static ExamPrep.competition.common.ExceptionMessages.CAR_MODEL_NULL_OR_EMPTY;

public class BaseCar implements Car{
    private String model;
    private int batteryCapacity;
    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        setModel(model);
        setBatteryCapacity(batteryCapacity);
        this.mileage = 0;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()){
            throw new NullPointerException(CAR_MODEL_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public void drive() {
        batteryCapacity -= 15;
        mileage += 25;
        if (batteryCapacity < 0){
            batteryCapacity = 0;
        }
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
