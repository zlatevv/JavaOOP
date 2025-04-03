package ExamPrep.restaurant.models.waiter;

//TODO
public class FullTimeWaiter extends BaseWaiter{
    private static final int EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        this.setEfficiency(this.getEfficiency() - 1);

        if (this.getEfficiency() < 0){
            this.setEfficiency(0);
        }
    }
}
