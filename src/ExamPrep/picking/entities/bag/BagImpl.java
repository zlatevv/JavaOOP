package ExamPrep.picking.entities.bag;

import java.util.ArrayList;
import java.util.Collection;

public class BagImpl implements Bag{
    private Collection<String> mushrooms;

    public BagImpl() {
        this.mushrooms = new ArrayList<>();
    }

    @Override
    public Collection<String> getMushrooms() {
        return this.mushrooms;
    }
}
