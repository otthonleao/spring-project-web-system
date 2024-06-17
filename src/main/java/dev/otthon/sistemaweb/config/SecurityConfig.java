package dev.otthon.sistemaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(customizer -> customizer
                .anyRequest()
                .authenticated() // Todas as requisições precisam estar autenticadas
//                .permitAll()
            ).formLogin(customizer -> customizer
                .loginPage("/auth/login") // Localização da rota de login
                .defaultSuccessUrl("/") // Rota de direcionamento em caso de login com sucesso
//                .usernameParameter("email") // Customizando o input de usuario que o spring deve procurar no atributo name do html
//                .passwordParameter("senha") // Customizando a input de senha que o spring deve procurar no atributo name do html
                .permitAll()
            ).logout(customizer -> customizer
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "GET"))
                .logoutSuccessUrl("/auth/login")
            ).build();
    }

    // ROTAS A SEREM IGNORADAS PELO SPRING SECURITY
    // NECESSÁRIO PARA LIBERAR A ESTILIZAÇÃO DAS PÁGINAS SEM TER FEITO O LOGIN
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("webjars/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
