package ExamPrep.harpoonDiver.core;

import ExamPrep.harpoonDiver.common.ConstantMessages;
import ExamPrep.harpoonDiver.common.ExceptionMessages;
import ExamPrep.harpoonDiver.models.diver.DeepWaterDiver;
import ExamPrep.harpoonDiver.models.diver.Diver;
import ExamPrep.harpoonDiver.models.diver.OpenWaterDiver;
import ExamPrep.harpoonDiver.models.diver.WreckDiver;
import ExamPrep.harpoonDiver.models.diving.DivingImpl;
import ExamPrep.harpoonDiver.models.divingSite.DivingSite;
import ExamPrep.harpoonDiver.models.divingSite.DivingSiteImpl;
import ExamPrep.harpoonDiver.repositories.DiverRepository;
import ExamPrep.harpoonDiver.repositories.DivingSiteRepository;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private DivingImpl action;
    private int sites;

    public ControllerImpl() {
        this.action = new DivingImpl();
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        switch (kind){
            case "DeepWaterDiver":
                diver = new DeepWaterDiver(diverName);
                break;
            case "OpenWaterDiver":
                diver = new OpenWaterDiver(diverName);
                break;
            case "WreckDiver":
                diver = new WreckDiver(diverName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        this.diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        divingSite.getSeaCreatures().addAll(Arrays.asList(seaCreatures));
        this.divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        if (!diverRepository.remove(diver)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }
        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> divers = diverRepository.getCollection()
                .stream()
                .filter(diver -> diver.getOxygen() > 30)
                .collect(Collectors.toList());
        if (divers.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }
        DivingSite divingSite = divingSiteRepository.byName(siteName);
        int removed = 0;
        action.searching(divingSite, divers);
        Iterator<Diver> iterator = divers.iterator();
        while (iterator.hasNext()) {
            Diver diver = iterator.next();
            if (!diver.canDive()) {
                iterator.remove();
                removed++;
            }
        }
        sites++;
        return String.format(ConstantMessages.SITE_DIVING, siteName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ConstantMessages.FINAL_DIVING_SITES, this.sites))
                .append(System.lineSeparator());
        stringBuilder.append(ConstantMessages.FINAL_DIVERS_STATISTICS);
        for (Diver diver : diverRepository.getCollection()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.FINAL_DIVER_NAME, diver.getName()))
                    .append(System.lineSeparator());
            stringBuilder.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, diver.getOxygen()))
                    .append(System.lineSeparator());
            if (diver.getSeaCatch().getSeaCreatures().isEmpty()){
                stringBuilder.append("Diver's catch: None");
            }else{
                stringBuilder.append(String.format(ConstantMessages.FINAL_DIVER_CATCH,
                        String.join(ConstantMessages.FINAL_DIVER_CATCH_DELIMITER, diver.getSeaCatch()
                                .getSeaCreatures())));
            }
        }
        return stringBuilder.toString();
    }
}
