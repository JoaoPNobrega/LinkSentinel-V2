package br.cesar.school.linksentinel.domain; // Ou o pacote onde está sua entidade Usuario

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring Data JPA criará automaticamente a implementação para este método
    // com base no nome. Ele procurará um usuário pelo campo 'email'.
    Optional<Usuario> findByEmail(String email);

    // Você pode adicionar outros métodos de consulta personalizados aqui se necessário
    // Ex: boolean existsByEmail(String email);
}