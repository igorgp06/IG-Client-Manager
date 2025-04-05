package br.com.igsolutions.igClientManager.service;

import br.com.igsolutions.igClientManager.model.Client;
import br.com.igsolutions.igClientManager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, Client newClient) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setEmail(newClient.getEmail());
                    client.setNumber(newClient.getNumber());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
