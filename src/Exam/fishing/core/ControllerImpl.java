package Exam.fishing.core;

import Exam.fishing.common.ConstantMessages;
import Exam.fishing.common.ExceptionMessages;
import Exam.fishing.entity.fisherman.AmateurFisherman;
import Exam.fishing.entity.fisherman.Fisherman;
import Exam.fishing.entity.fisherman.SkilledFisherman;
import Exam.fishing.entity.fishing.FishingImpl;
import Exam.fishing.entity.site.Site;
import Exam.fishing.entity.site.SiteImpl;
import Exam.fishing.repository.SiteRepository;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private SiteRepository siteRepository;
    private FishingImpl fishing;

    public ControllerImpl() {
        this.siteRepository = new SiteRepository();
        this.fishing = new FishingImpl();
    }

    @Override
    public String addSite(String siteType, String siteName, int quota) {
        if (quota < 0){
            throw new IllegalArgumentException(ExceptionMessages.SITE_QUOTA_CANNOT_BE_NEGATIVE);
        }
        if (siteRepository.byName(siteName) != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_SITE);
        }
        Site site = new SiteImpl(siteName, siteType, quota);
        siteRepository.add(site);
        return String.format(ConstantMessages.SITE_ADDED, siteName, siteType);
    }

    @Override
    public String addFisherman(String siteName, String fishermanType, String fishermanName) {
        Site site = siteRepository.byName(siteName);
        for (Fisherman fisherman : site.getFishermen()) {
            if (fisherman.getName().equals(fishermanName)){
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_FISHERMAN, fishermanName));
            }
        }
        Fisherman fisherman;
        switch (fishermanType){
            case "AmateurFisherman":
                fisherman = new AmateurFisherman(fishermanName);
                break;
            case "SkilledFisherman":
                fisherman = new SkilledFisherman(fishermanName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISHERMAN);
        }
        site.getFishermen().add(fisherman);
        return String.format(ConstantMessages.FISHERMAN_ADDED, fishermanType, fishermanName);
    }

    @Override
    public String goFishing(String siteName) {
        Site site = siteRepository.byName(siteName);
        if (site == null){
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_SITE, siteName));
        }
        fishing.startFishing(site);
        if (site.getQuota() > 0){
            return String.format(ConstantMessages.FISHING_SITE, siteName, site.getType(), site.getQuota());
        }
        return String.format(ConstantMessages.NO_MORE_FISH_ALLOWED, siteName, site.getType());

    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Site site : this.siteRepository.getCollection()) {
            stringBuilder.append(String.format(ConstantMessages.FINAL_FISHING_SITE_INFO,
                    site.getName(), site.getType()))
                    .append(System.lineSeparator());
            Collection<Fisherman> fishermanWithHarvest = site.getFishermen()
                    .stream()
                    .filter(fisherman -> fisherman.getHarvest() > 0)
                    .toList();
            for (Fisherman fisherman : fishermanWithHarvest) {
                stringBuilder.append(String.format("Name: %s%n", fisherman.getName()));
                stringBuilder.append(String.format("Bait left: %d%n", fisherman.getBait()));
                stringBuilder.append(String.format("Caught fishes: %d%n", fisherman.getHarvest()));
            }

        }
        return stringBuilder.toString();
    }
}
