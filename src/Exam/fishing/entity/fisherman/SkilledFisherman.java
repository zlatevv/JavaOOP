package Exam.fishing.entity.fisherman;

public class SkilledFisherman extends BaseFisherman{
    private static final int INITIAL_BAIT = 100;
    public SkilledFisherman(String name) {
        super(name, INITIAL_BAIT);
    }
}
