package ExamPrep.harpoonDiver.models.diving;

import ExamPrep.harpoonDiver.models.diver.Diver;
import ExamPrep.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.Iterator;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        for (Diver diver : divers) {
            Iterator<String> creatures = divingSite.getSeaCreatures().iterator();
            while (diver.canDive() && creatures.hasNext()){
                String creature = creatures.next();
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(creature);
                creatures.remove();
            }
        }
    }
}
