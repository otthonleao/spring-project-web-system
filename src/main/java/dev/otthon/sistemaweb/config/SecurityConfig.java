package dev.otthon.sistemaweb.config;

import dev.otthon.sistemaweb.core.services.authorization.Authority;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig {

    private final AuthConfigProperties authConfigProperties;

    private static final String[] ADMIN_MATCHERS = {

            "/*/create",
            "/*/edit/**",
            "/*/delete/**",
//            "/clients/create",
//            "/clients/edit/**",
//            "/clients/delete/**",
//            "/employees/create",
//            "/employees/edit/**",
//            "/employees/delete/**",
//            "/projects/create",
//            "/projects/edit/**",
//            "/projects/delete/**",
//            "/positions/create",
//            "/positions/edit/**",
//            "/positions/delete/**",
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(customizer -> customizer
                .requestMatchers(ADMIN_MATCHERS).hasAuthority(Authority.ADMIN.name())
                        .anyRequest()
                        .authenticated() // Todas as requisições dentro de "/clients/create" precisam estar autenticadas com ADMIN
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
            ).rememberMe(customizer -> customizer
                .key(authConfigProperties.getRememberMeToken())
                .tokenValiditySeconds(authConfigProperties.getRememberMeValiditySeconds()) // Deixa o user logado por 7 dias
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
