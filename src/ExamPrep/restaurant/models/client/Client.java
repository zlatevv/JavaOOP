package ExamPrep.restaurant.models.client;

import java.util.Collection;

public interface Client {

    Collection<String> getClientOrders();

    String getName();
}
