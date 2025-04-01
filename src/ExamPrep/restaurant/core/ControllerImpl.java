package ExamPrep.restaurant.core;

import ExamPrep.restaurant.models.client.Client;
import ExamPrep.restaurant.models.client.ClientImpl;
import ExamPrep.restaurant.models.waiter.FullTimeWaiter;
import ExamPrep.restaurant.models.waiter.HalfTimeWaiter;
import ExamPrep.restaurant.models.waiter.Waiter;
import ExamPrep.restaurant.models.working.WorkingImpl;
import ExamPrep.restaurant.repositories.ClientRepository;
import ExamPrep.restaurant.repositories.WaiterRepository;

import java.util.Arrays;

import static ExamPrep.restaurant.common.ConstantMessages.*;
import static ExamPrep.restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private ClientRepository clientRepository;
    private WaiterRepository waiterRepository;
    private WorkingImpl working;
    private int ordersCompleted;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
        this.working = new WorkingImpl();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        switch (type){
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        client.getClientOrders().addAll(Arrays.asList(orders));
        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        if (waiterRepository.byName(waiterName) == null){
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        Waiter waiter = waiterRepository.byName(waiterName);
        waiterRepository.remove(waiter);
        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        if (clientRepository.byName(clientName) == null){
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST);
        }
        Client client = clientRepository.byName(clientName);
        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (waiterRepository.getCollection().isEmpty()){
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Client client = clientRepository.byName(clientName);
        working.takingOrders(client, waiterRepository.getCollection());
        this.ordersCompleted++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(String.format(FINAL_CLIENTS_COUNT, this.ordersCompleted));
        stringbuilder.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());

        for (Waiter waiter : waiterRepository.getCollection()) {
            stringbuilder.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            stringbuilder.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());
            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                stringbuilder.append("Taken orders: None").append(System.lineSeparator());
            } else {
                stringbuilder.append(String.format(FINAL_WAITER_ORDERS,
                                String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList())))
                        .append(System.lineSeparator());
            }
        }
        return stringbuilder.toString();
    }
}
