package ExamPrep.restaurant.models.working;

import ExamPrep.restaurant.models.client.Client;
import ExamPrep.restaurant.models.waiter.Waiter;

import java.util.Collection;

public interface Working {
    void takingOrders(Client client, Collection<Waiter> waiters);

}
