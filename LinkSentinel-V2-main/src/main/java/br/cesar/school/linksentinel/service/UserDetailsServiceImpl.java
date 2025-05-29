package br.cesar.school.linksentinel.service; // Ou o pacote que você escolheu

import br.cesar.school.linksentinel.domain.Usuario;
import br.cesar.school.linksentinel.domain.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority; // Para futuras roles
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Para futuras roles
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections; // Para lista vazia de authorities
// import java.util.Set; // Para futuras roles
// import java.util.stream.Collectors; // Para futuras roles

@Service("userDetailsService") // Importante nomear o bean para o Spring Security encontrar
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // O "username" que o Spring Security usa para login é o e-mail no nosso caso
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado com o e-mail: " + email));

        // Por enquanto, não estamos usando roles/authorities.
        // Se você adicionar roles à sua entidade Usuario (ex: Set<Role> roles),
        // você precisaria mapeá-los para GrantedAuthority aqui.
        // Set<GrantedAuthority> authorities = usuario.getRoles().stream()
        //        .map(role -> new SimpleGrantedAuthority(role.getName()))
        //        .collect(Collectors.toSet());

        return new User(
                usuario.getEmail(),          // username que o Spring Security usa
                usuario.getSenhaHash(),      // senha com hash do banco
                Collections.emptyList()      // authorities (roles/permissões) - vazio por agora
                // enabled, accountNonExpired, credentialsNonExpired, accountNonLocked - todos true por padrão no construtor User
        );
    }
}