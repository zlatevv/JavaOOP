package ExamPrep.harpoonDiver.repositories;

import ExamPrep.harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiverRepository implements Repository<Diver> {
    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(divers);
    }

    @Override
    public void add(Diver entity) {
        divers.add(entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return divers.remove(entity);
    }

    @Override
    public Diver byName(String name) {
        for (Diver diver : divers) {
            if (diver.getName().equals(name)){
                return diver;
            }
        }
        return null;
    }
}
