package com.nttdata.client.service;

import com.nttdata.client.entity.Client;
import com.nttdata.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateClientById(Client request, Long id) {
        Client client = clientRepository.findById(id).get();

        client.setName(request.getName());
        client.setLastName(request.getLastName());
        client.setDni(request.getDni());
        client.setEmail(request.getEmail());

        clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

}
