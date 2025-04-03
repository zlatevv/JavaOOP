package ExamPrep.climbers.models.climber;

public class WallClimber extends BaseClimber{
    private static final int STRENGTH = 90;
    public WallClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        this.setStrength(this.getStrength() - 30);
        if (this.getStrength() < 0){
            this.setStrength(0);
        }
    }
}
