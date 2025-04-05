package Exam.fishing.entity.site;

import Exam.fishing.entity.fisherman.Fisherman;

import java.util.Collection;

public interface Site {

    Collection<Fisherman> getFishermen();

    String getName();

    String getType();

    int getQuota();

    void reduceQuota();

}
