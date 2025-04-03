package ExamPrep.climbers.models.climbing;

import ExamPrep.climbers.models.climber.Climber;
import ExamPrep.climbers.models.mountain.Mountain;

import java.util.Collection;
import java.util.Iterator;

public class ClimbingImpl implements Climbing{
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        for (Climber climber : climbers) {
            Iterator<String> iterator = mountain.getPeaksList().iterator();
            while (climber.canClimb() && iterator.hasNext()){
                String peak = iterator.next();
                climber.climb();
                climber.getRoster().getPeaks().add(peak);
                iterator.remove();
            }
        }
    }
}
