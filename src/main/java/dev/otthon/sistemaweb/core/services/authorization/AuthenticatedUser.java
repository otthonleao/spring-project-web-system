package dev.otthon.sistemaweb.core.services.authorization;

import dev.otthon.sistemaweb.core.models.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AuthenticatedUser implements UserDetails {

    private final Employee employee;


    /* AUTORIZAÇÕES QUE O USUÁRIO PODE FAZER NO SISTEMA */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.NO_AUTHORITIES; // Nenhum sistema de autorização
    }

    /* COMO O SISTEMA OBTEM A SENHA DO USUÁRIO */
    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    /* NOME DO USUÁRIO QUE O SISTEMA IRÁ AUTENTICAR */
    @Override
    public String getUsername() {
        return employee.getEmail();
    }

    /* PARA SABER SE A CONTA DO USUÁRIO ESTÁ EXPIRADA OU NÃO */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* PARA SABER SE A CONTA DO USUÁRIO ESTÁ BLOQUEADA OU NÃO */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* PARA SABER SE AS CREDENCIAIS/SENHA DO USUÁRIO ESTÁ EXPIRADA */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* PARA SABER SE O USUÁRIO ESTÁ ATIVO */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
