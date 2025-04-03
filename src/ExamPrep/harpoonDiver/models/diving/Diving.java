package ExamPrep.harpoonDiver.models.diving;

import ExamPrep.harpoonDiver.models.diver.Diver;
import ExamPrep.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public interface Diving {

    void searching(DivingSite divingSite, Collection<Diver> divers);
}
