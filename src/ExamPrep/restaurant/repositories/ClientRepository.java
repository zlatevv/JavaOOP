package ExamPrep.restaurant.repositories;

import ExamPrep.restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientRepository implements Repository<Client>{
    private Collection<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return Collections.unmodifiableCollection(clients);
    }

    @Override
    public void add(Client entity) {
        clients.add(entity);
    }

    @Override
    public boolean remove(Client entity) {
        return clients.remove(entity);
    }

    @Override
    public Client byName(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
}
