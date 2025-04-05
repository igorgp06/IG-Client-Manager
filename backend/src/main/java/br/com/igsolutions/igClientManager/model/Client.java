package br.com.igsolutions.igClientManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Preencha o nome do cliente!")
    private String name;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Preencha o email do cliente!")
    private String email;

    @NotBlank(message = "Preencha o telefone do cliente!")
    private String number;
}
