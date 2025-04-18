package br.com.igsolutions.igClientManager.controller;

import br.com.igsolutions.igClientManager.exception.ResourceNotFoundException;
import br.com.igsolutions.igClientManager.model.Client;
import br.com.igsolutions.igClientManager.repository.ClientRepository;
import br.com.igsolutions.igClientManager.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // FERRAMENTA APENAS PARA DEBUG
    @GetMapping
    public List<Client> listCustomers() {
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public Client getCustomerById(@PathVariable Long id) {
        return clientService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com o ID " + id + " não encontrado!"));
    }

    @PostMapping
    public Client createCustomer(@Valid @RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void delCustomer(@PathVariable Long id) {
        clientService.delete(id);
    }

    @PutMapping("/{id}")
    public Client updateCustomer(@PathVariable Long id, @Valid @RequestBody Client client) {
        return clientService.update(id, client);
    }

}
