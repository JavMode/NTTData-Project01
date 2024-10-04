package com.nttdata.client.controller;

import com.nttdata.client.entity.Client;
import com.nttdata.client.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/clientes")
    public ResponseEntity<?> getClients(){
        return ResponseEntity.ok(clientService.getClients());
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody Client client){
        clientService.saveClient(client);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClientById(@RequestBody Client client, @PathVariable Long id){
        clientService.updateClientById(client, id);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClientById(@PathVariable Long id){
        clientService.deleteClientById(id);
    }

}
