package com.nttdata.client.service;

import com.nttdata.client.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();

    void saveClient(Client client);

    Client getClientById(Long id);

    void updateClientById(Client client, Long id);

    void deleteClientById(Long id);

}
