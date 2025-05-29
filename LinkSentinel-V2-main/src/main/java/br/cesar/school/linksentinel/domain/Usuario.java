package br.cesar.school.linksentinel.domain; // Ou o pacote que você escolheu para o domínio

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Lombok (opcional, mas útil)
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuarios") // Define o nome da tabela no banco
@Getter // Lombok para gerar getters
@Setter // Lombok para gerar setters
@NoArgsConstructor // Lombok para gerar construtor sem argumentos (requerido pelo JPA)
@AllArgsConstructor // Lombok para gerar construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Lombok para gerar equals e hashCode baseados no id
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento pelo banco
    private Long id;

    @NotBlank(message = "O e-mail não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    @Column(unique = true, nullable = false, length = 100) // E-mail deve ser único e não nulo
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") // Validação de tamanho da senha (hash)
    @Column(nullable = false, length = 255) // Armazenará o hash da senha
    private String senhaHash;

    // Você pode adicionar outros campos como nome, data de cadastro, etc.
    // private String nomeCompleto;
    // private java.time.LocalDateTime dataCadastro;

    // Construtor útil para criar novos usuários (sem o id, que será gerado)
    public Usuario(String email, String senhaHash) {
        this.email = email;
        this.senhaHash = senhaHash;
    }
}