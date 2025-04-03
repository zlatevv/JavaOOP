package ExamPrep.climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final int STRENGTH = 120;
    public RockClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        this.setStrength(this.getStrength() - 60);
        if (this.getStrength() < 0){
            this.setStrength(0);
        }
    }
}
