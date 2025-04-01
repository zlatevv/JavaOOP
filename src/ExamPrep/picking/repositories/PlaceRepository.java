package ExamPrep.picking.repositories;

import ExamPrep.picking.entities.places.Place;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlaceRepository implements Repository<Place>{
    private Collection<Place> places;

    public PlaceRepository() {
        this.places = new ArrayList<>();
    }

    @Override
    public Collection<Place> getCollection() {
        return Collections.unmodifiableCollection(places);
    }

    @Override
    public void add(Place entity) {
        places.add(entity);
    }

    @Override
    public boolean remove(Place entity) {
        return places.remove(entity);
    }

    @Override
    public Place byName(String name) {
        for (Place place : places) {
            if (place.getName().equals(name)){
                return place;
            }
        }
        return null;
    }
}
