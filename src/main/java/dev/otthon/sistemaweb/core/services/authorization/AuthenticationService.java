package dev.otthon.sistemaweb.core.services.authorization;

import dev.otthon.sistemaweb.core.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* É POR MEIO DESSA CLASSE QUE O SPRING VAI CONSEGUIR BUSCAR O USUÁRIO RETORNANDO UM UserDetails
* LOGO, É NECESSÁRIO QUE NO REPOSITORY TENHA UM MÉTODO QUE RETORNE O USER QUE SERÁ UTILIZADO
* PARA FAZER O LOGIN, NESSE CASO VAMOS UTILIZAR O EMAIL.
*
* OBS: Nesse caso, o <input> onde está o email no HTML deve receber o atributo name="username"
* para que o spring possa identificar qual será usado para fazer o login.
* */

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return employeeRepository.findByEmail(username)
                .map(AuthenticatedUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username credential"));

    }
}
