package br.cesar.school.linksentinel.config;

import br.cesar.school.linksentinel.ui.LoginView; // Certifique-se que este import está correto e a classe LoginView existe
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1. Primeiro, defina TODAS as suas regras de autorização de requisição HTTP
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(
                        AntPathRequestMatcher.antMatcher("/registrar"),
                        AntPathRequestMatcher.antMatcher("/login"),        // Permitir acesso público à tela de login
                        AntPathRequestMatcher.antMatcher("/h2-console/**"), // Permissão para o H2 Console
                        // Recursos estáticos do Vaadin e outros que precisam ser públicos
                        AntPathRequestMatcher.antMatcher("/VAADIN/**"),
                        AntPathRequestMatcher.antMatcher("/frontend/**"),
                        AntPathRequestMatcher.antMatcher("/images/**"),
                        AntPathRequestMatcher.antMatcher("/icons/**"),
                        AntPathRequestMatcher.antMatcher("/manifest.webmanifest"),
                        AntPathRequestMatcher.antMatcher("/sw.js"),
                        AntPathRequestMatcher.antMatcher("/offline.html")
                ).permitAll() // Permite acesso público a estas URLs
                .anyRequest().authenticated() // QUALQUER OUTRA requisição precisa de autenticação
        );

        // 2. Configurações específicas para o H2 Console (IMPORTANTÍSSIMO que venham DEPOIS do authorizeHttpRequests principal, mas ANTES do super.configure)
        http.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        // 3. CHAME O super.configure(http) DEPOIS de suas regras de autorização principais
        //    e das configurações específicas do H2 que podem afetar o HttpSecurity globalmente.
        //    Isso permite que VaadinWebSecurity aplique suas configurações de segurança
        //    para as views Vaadin, respeitando o que você já configurou.
        super.configure(http);

        // 4. Configure sua view de login customizada (DEPOIS do super.configure)
        setLoginView(http, LoginView.class, "/logout"); // Use sua LoginView
    }

    // O UserDetailsService em memória está comentado pois usaremos o do banco.
    /*
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        // ... exemplo de usuários em memória ...
        return new InMemoryUserDetailsManager(user, admin);
    }
    */
}