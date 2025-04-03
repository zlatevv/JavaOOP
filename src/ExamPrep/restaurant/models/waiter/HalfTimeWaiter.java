package ExamPrep.restaurant.models.waiter;

//TODO
public class HalfTimeWaiter  extends BaseWaiter{
    private static final int EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        this.setEfficiency(this.getEfficiency() - 2);

        if (this.getEfficiency() < 0){
            this.setEfficiency(0);
        }
    }
}
