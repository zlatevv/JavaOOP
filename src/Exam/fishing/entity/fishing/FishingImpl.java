package Exam.fishing.entity.fishing;

import Exam.fishing.entity.fisherman.Fisherman;
import Exam.fishing.entity.site.Site;

import java.util.Collection;

public class FishingImpl implements Fishing{
    @Override
    public void startFishing(Site site) {
        Collection<Fisherman> fishermen = site.getFishermen();
        while (site.getQuota() > 0){
            boolean fished = false;
            for (Fisherman fisherman : fishermen) {
                if (fisherman.getBait() <= 0){
                    continue;
                }
                while (fisherman.getBait() > 0 && site.getQuota() > 0){
                    fisherman.fishing();
                    site.reduceQuota();
                    if (site.getQuota() <= 0) {
                        break;
                    }
                }
                if (site.getQuota() <= 0){
                    break;
                }
            }
            if (!fished){
                break;
            }
        }
    }
}
