package br.com.igsolutions.igClientManager.controller;

import br.com.igsolutions.igClientManager.dto.FreelancerDTO;
import br.com.igsolutions.igClientManager.dto.LoginDTO;
import br.com.igsolutions.igClientManager.model.Freelancer;
import br.com.igsolutions.igClientManager.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/freelancers")
@CrossOrigin(origins = "*")
public class FreelancerController {

    @Autowired
    private FreelancerService freelancerService;

    // FERRAMENTA APENAS PARA DEBUG
    @GetMapping
    public List<Freelancer> listAll() {
        return freelancerService.listAll();
    }

    @PostMapping("/register")
    public Freelancer authenticate(@RequestBody FreelancerDTO dto) {
        return freelancerService.registerFreelancer(dto);
    }

    @PostMapping("/login")
    public Freelancer login(@RequestBody LoginDTO dto) {
        return freelancerService.login(dto);
    }

    @DeleteMapping
    public void delCustomer(@PathVariable Long id) {
        freelancerService.delete(id);
    }
}

