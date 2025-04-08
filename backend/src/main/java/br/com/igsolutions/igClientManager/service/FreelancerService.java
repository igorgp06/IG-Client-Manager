package br.com.igsolutions.igClientManager.service;

import br.com.igsolutions.igClientManager.dto.FreelancerDTO;
import br.com.igsolutions.igClientManager.dto.LoginDTO;
import br.com.igsolutions.igClientManager.model.Freelancer;
import br.com.igsolutions.igClientManager.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreelancerService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    public Freelancer registerFreelancer(FreelancerDTO dto) {
        if (freelancerRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado, faça login na sua conta!");
        }

        Freelancer newFreelancer = Freelancer.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        return freelancerRepository.save(newFreelancer);
    }

    public Freelancer login(LoginDTO dto) {
        Optional<Freelancer> freelancer = freelancerRepository.findByEmail(dto.getEmail());

        if (freelancer.isEmpty() || !freelancer.get().getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("E-mail ou senha inválidos!");
        }
        return freelancer.get();
    }
}
