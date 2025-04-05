package Exam.fishing.entity.fisherman;

import Exam.fishing.common.ExceptionMessages;

public class BaseFisherman implements Fisherman{
    private String name;
    private int harvest = 0;
    private int bait;

    public BaseFisherman(String name, int bait) {
        setName(name);
        setBait(bait);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.FISHERMAN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public void setBait(int bait) {
        this.bait = bait;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHarvest() {
        return this.harvest;
    }

    @Override
    public int getBait() {
        return this.bait;
    }

    @Override
    public void fishing() {
        this.harvest++;
        this.bait -= 10;
        if (this.bait < 0){
            this.bait = 0;
        }
    }
}
