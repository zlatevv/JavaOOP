package Exam.fishing.entity.fisherman;

public class AmateurFisherman extends BaseFisherman{
    private static final int INITIAL_BAIT = 50;
    public AmateurFisherman(String name) {
        super(name, INITIAL_BAIT);
    }
}
