package ExamPrep.picking.entities.places;

import ExamPrep.picking.entities.pickers.Picker;

import java.util.Collection;

public interface Place {

    String getName();
    Collection<String> getMushrooms();
    Collection<Picker> getPickers();
}
