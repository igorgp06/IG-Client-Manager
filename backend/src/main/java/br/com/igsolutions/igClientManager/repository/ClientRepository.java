package br.com.igsolutions.igClientManager.repository;

import br.com.igsolutions.igClientManager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
