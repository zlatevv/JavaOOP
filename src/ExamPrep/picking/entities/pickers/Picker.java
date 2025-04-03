package ExamPrep.picking.entities.pickers;

import ExamPrep.picking.entities.bag.Bag;

public interface Picker {

    String getName();

    int getVitality();

    Bag getBag();

    void pick();
}
