package ExamPrep.climbers.core;

import ExamPrep.climbers.common.ConstantMessages;
import ExamPrep.climbers.common.ExceptionMessages;
import ExamPrep.climbers.models.climber.Climber;
import ExamPrep.climbers.models.climber.RockClimber;
import ExamPrep.climbers.models.climber.WallClimber;
import ExamPrep.climbers.models.climbing.Climbing;
import ExamPrep.climbers.models.climbing.ClimbingImpl;
import ExamPrep.climbers.models.mountain.Mountain;
import ExamPrep.climbers.models.mountain.MountainImpl;
import ExamPrep.climbers.repositories.ClimberRepository;
import ExamPrep.climbers.repositories.MountainRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private MountainRepository mountainRepository;
    private ClimberRepository climberRepository;
    private Climbing climbing;
    private int mountains = 0;

    public ControllerImpl() {
        this.mountainRepository = new MountainRepository();
        this.climberRepository = new ClimberRepository();
        this.climbing = new ClimbingImpl();
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber;
        switch (type){
            case "RockClimber":
                climber = new RockClimber(climberName);
                break;
            case "WallClimber":
                climber = new WallClimber(climberName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
        }
        climberRepository.add(climber);
        return String.format(ConstantMessages.CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName);
        mountain.getPeaksList().addAll(Arrays.asList(peaks));
        mountainRepository.add(mountain);
        return String.format(ConstantMessages.MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        if (climberRepository.byName(climberName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CLIMBER_DOES_NOT_EXIST, climberName));
        }
        climberRepository.remove(climberRepository.byName(climberName));
        return String.format(ConstantMessages.CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        if (climberRepository.getCollection().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.THERE_ARE_NO_CLIMBERS);
        }
        this.climbing.conqueringPeaks(mountainRepository.byName(mountainName), climberRepository.getCollection());
        int removedClimbers = climberRepository.getCollection().stream()
                .filter(climber -> !climber.canClimb())
                .collect(Collectors.toList())
                .size();
        this.mountains++;
        return String.format(ConstantMessages.PEAK_CLIMBING, mountainName, removedClimbers);
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        build.append(String.format(ConstantMessages.FINAL_MOUNTAIN_COUNT, this.mountains));
        build.append(System.lineSeparator());
        build.append(ConstantMessages.FINAL_CLIMBERS_STATISTICS);

        Collection<Climber> climbers = climberRepository.getCollection();
        for (Climber climber : climbers) {
            build.append(System.lineSeparator());
            build.append(String.format(ConstantMessages.FINAL_CLIMBER_NAME, climber.getName()));
            build.append(System.lineSeparator());
            build.append(String.format(ConstantMessages.FINAL_CLIMBER_STRENGTH, climber.getStrength()));
            build.append(System.lineSeparator());
            if (climber.getRoster().getPeaks().isEmpty()) {
                build.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS, "None"));

            } else {
                build.append(String.format(ConstantMessages.FINAL_CLIMBER_PEAKS,
                        String.join(ConstantMessages.FINAL_CLIMBER_FINDINGS_DELIMITER, climber.getRoster().getPeaks())));
            }
        }
        return build.toString();
    }
}
