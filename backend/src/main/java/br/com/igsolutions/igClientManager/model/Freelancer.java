package br.com.igsolutions.igClientManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    private LocalDateTime registrationDate;

    @PrePersist
    public void prePersist() {
        registrationDate = LocalDateTime.now();
    }
}
