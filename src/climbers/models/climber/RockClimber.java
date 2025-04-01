package climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final int STRENGTH = 120;
    public RockClimber(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void climb() {
        if (this.canClimb()){
            this.setStrength(this.getStrength() - 30);
            if (this.getStrength() < 0){
                this.setStrength(0);
            }
        }
    }
}
