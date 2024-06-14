package dev.otthon.sistemaweb.config;

import dev.otthon.sistemaweb.core.models.Client;
import dev.otthon.sistemaweb.core.utils.StringUtils;
import dev.otthon.sistemaweb.web.clients.dtos.ClientForm;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(ClientForm.class, Client.class)
                .addMappings(mapper -> mapper
                        .using(toCleanedPhone())
                        .map(ClientForm::getPhone, Client::setPhone)
                );

        modelMapper.createTypeMap(Client.class, ClientForm.class)
                .addMappings(mapper -> mapper
                        .using(toFormattedPhone())
                        .map(Client::getPhone, ClientForm::setPhone)
                );

        return modelMapper;
    }

    private Converter<String, String> toCleanedPhone() {
        return context -> StringUtils.cleanPhone(context.getSource());
    }

    private Converter<String, String> toFormattedPhone() {
        return context -> StringUtils.formatPhone(context.getSource());
    }
}
