package br.com.igsolutions.igClientManager.controller;

import br.com.igsolutions.igClientManager.model.Client;
import br.com.igsolutions.igClientManager.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> listCustomers() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createCustomer(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void delCustomer(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
