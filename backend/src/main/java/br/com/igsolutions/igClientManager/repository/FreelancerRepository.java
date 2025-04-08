package br.com.igsolutions.igClientManager.repository;

import br.com.igsolutions.igClientManager.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    Optional<Freelancer> findByEmail(String email);
}
