package ExamPrep.climbers.models.climbing;

import ExamPrep.climbers.models.climber.Climber;
import ExamPrep.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
