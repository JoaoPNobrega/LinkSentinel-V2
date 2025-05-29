package br.cesar.school.linksentinel.service; // Ou o pacote que você escolheu para serviços

import br.cesar.school.linksentinel.domain.Usuario;
import br.cesar.school.linksentinel.domain.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Para o hash da senha
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder; // Para fazer o hash da senha

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Instancia o encoder
    }

    @Transactional // Garante que a operação seja atômica
    public Usuario registrarNovoUsuario(String email, String senha) throws EmailJaCadastradoException {
        // 1. Verificar se o e-mail já existe
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(email);
        if (usuarioExistente.isPresent()) {
            throw new EmailJaCadastradoException("O e-mail '" + email + "' já está cadastrado.");
        }

        // 2. Validar a senha (ex: complexidade, tamanho) - pode ser feito aqui ou na entidade com Bean Validation
        // Por simplicidade, vamos assumir que a anotação @Size na entidade já cuida do tamanho mínimo.
        // Se precisar de regras mais complexas (ex: requer maiúsculas, números, etc.), adicione aqui.

        // 3. Fazer o hash da senha
        String senhaHasheada = passwordEncoder.encode(senha);

        // 4. Criar a nova entidade Usuario
        Usuario novoUsuario = new Usuario(email, senhaHasheada);
        // Se tiver outros campos para setar no registro (ex: dataCadastro), faça aqui.
        // novoUsuario.setDataCadastro(java.time.LocalDateTime.now());

        // 5. Salvar o novo usuário no banco
        return usuarioRepository.save(novoUsuario);
    }

    // Você pode adicionar outros métodos de serviço aqui depois, como:
    // - login(String email, String senha)
    // - solicitarRedefinicaoSenha(String email)
    // - alterarSenha(Long usuarioId, String senhaAntiga, String novaSenha)
    // etc.
}