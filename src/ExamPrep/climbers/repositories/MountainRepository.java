package ExamPrep.climbers.repositories;

import ExamPrep.climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class MountainRepository implements Repository<Mountain> {
    private Collection<Mountain> mountains;

    public MountainRepository() {
        this.mountains = new ArrayList<>();
    }

    @Override
    public Collection<Mountain> getCollection() {
        return Collections.unmodifiableCollection(mountains);
    }

    @Override
    public void add(Mountain entity) {
        this.mountains.add(entity);
    }

    @Override
    public boolean remove(Mountain entity) {
        return this.mountains.remove(entity);
    }

    @Override
    public Mountain byName(String name) {
        for (Mountain mountain : mountains) {
            if (mountain.getName().equals(name)){
                return mountain;
            }
        }
        return null;
    }
}
