package Exam.fishing.entity.site;

import Exam.fishing.common.ExceptionMessages;
import Exam.fishing.entity.fisherman.Fisherman;

import java.util.ArrayList;
import java.util.Collection;

public class SiteImpl implements Site{
    private String name;
    private String type;
    private int quota;
    private Collection<Fisherman> fishermen;

    public SiteImpl(String name, String type, int quota) {
        setName(name);
        setType(type);
        setQuota(quota);
        this.fishermen = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    @Override
    public Collection<Fisherman> getFishermen() {
        return this.fishermen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getQuota() {
        return this.quota;
    }

    @Override
    public void reduceQuota() {
        this.quota--;
    }
}
