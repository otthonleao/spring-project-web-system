package dev.otthon.sistemaweb.core.validators;

import dev.otthon.sistemaweb.core.repositories.ClientRepository;
import dev.otthon.sistemaweb.core.services.http.HttpService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@RequiredArgsConstructor
public class ClientEmailUniqueValidator implements ConstraintValidator<ClientEmailUnique, String> {

    private final HttpService httpService;
    private final ClientRepository clientRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

//        var attr = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//        var attrMap = (Map<String, String>) attr;
//        var id = attrMap.getOrDefault("id", "0");
//        var idLong = Long.parseLong(id);
//        System.out.println(idLong);
//
//        if (idLong != 0) {
//            return clientRepository.findByEmailAndIdNot(value, idLong).isEmpty();
//        }

        var id = httpService.getPathVariable("id", Long.class);

        if (id.isPresent()) {
            return clientRepository.findByEmailAndIdNot(value, id.get()).isEmpty();
        }

        return clientRepository.findByEmail(value).isEmpty();
    }

}
