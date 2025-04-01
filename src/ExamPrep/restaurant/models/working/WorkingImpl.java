package ExamPrep.restaurant.models.working;

import ExamPrep.restaurant.models.client.Client;
import ExamPrep.restaurant.models.waiter.Waiter;

import java.util.Collection;
import java.util.Iterator;

public class WorkingImpl implements Working{
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        for (Waiter waiter : waiters) {
            Iterator<String> iterator = client.getClientOrders().iterator();
            while (iterator.hasNext()) {
                String clientOrder = iterator.next();
                if (!waiter.canWork()) {
                    break;
                }
                waiter.work();
                waiter.takenOrders().getOrdersList().add(clientOrder);
                iterator.remove();
                if (!waiter.canWork()) {
                    break;
                }
            }
        }
    }
}
