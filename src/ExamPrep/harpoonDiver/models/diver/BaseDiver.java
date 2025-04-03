package ExamPrep.harpoonDiver.models.diver;

import ExamPrep.harpoonDiver.common.ExceptionMessages;
import ExamPrep.harpoonDiver.models.seaCatch.BaseSeaCatch;
import ExamPrep.harpoonDiver.models.seaCatch.SeaCatch;

public class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.seaCatch =  new BaseSeaCatch();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0){
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public void shoot() {
        this.oxygen -= 30;
        if (this.oxygen < 0){
            this.oxygen = 0;
        }
    }
}
