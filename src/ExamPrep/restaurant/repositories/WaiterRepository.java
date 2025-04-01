package ExamPrep.restaurant.repositories;

import ExamPrep.restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class WaiterRepository implements Repository<Waiter>{
    private Collection<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(waiters);
    }

    @Override
    public void add(Waiter entity) {
        this.waiters.add(entity);
    }

    @Override
    public boolean remove(Waiter entity) {
        return waiters.remove(entity);
    }

    @Override
    public Waiter byName(String name) {
        for (Waiter waiter : waiters) {
            if (waiter.getName().equals(name)){
                return waiter;
            }
        }
        return null;
    }
}
