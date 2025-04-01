package ExamPrep.picking.entities.action;

import ExamPrep.picking.entities.pickers.Picker;
import ExamPrep.picking.entities.places.Place;

import java.util.Collection;
import java.util.Iterator;

public class ActionImpl implements Action{
    @Override
    public void startPicking(Place place) {
        Collection<Picker> pickers = place.getPickers();
        for (Picker picker : pickers) {
            Iterator<String> iterator = place.getMushrooms().iterator();
            while (iterator.hasNext()){
                if (picker.getVitality() == 0){
                    break;
                }
                String mushroom = iterator.next();
                if (mushroom.startsWith("poisonous")){
                    picker.pick();
                    iterator.remove();
                    picker.getBag().getMushrooms().clear();
                    continue;
                }
                picker.pick();
                picker.getBag().getMushrooms().add(mushroom);
                iterator.remove();
                if (picker.getVitality() <= 0){
                    break;
                }
            }
        }
    }
}
