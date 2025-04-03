package ExamPrep.climbers.repositories;

import ExamPrep.climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber> {
    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(climbers);
    }

    @Override
    public void add(Climber entity) {
        climbers.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return climbers.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        for (Climber climber : climbers) {
            if (climber.getName().equals(name)){
                return climber;
            }
        }
        return null;
    }
}
