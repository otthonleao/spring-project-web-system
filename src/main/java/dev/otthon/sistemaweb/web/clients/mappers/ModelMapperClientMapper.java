package dev.otthon.sistemaweb.web.clients.mappers;

import dev.otthon.sistemaweb.core.models.Client;
import dev.otthon.sistemaweb.web.clients.dtos.ClientForm;
import dev.otthon.sistemaweb.web.clients.dtos.ClientListItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "modelmapper"
)
public class ModelMapperClientMapper implements ClientMapper {

    private final ModelMapper modelMapper;

    @Override
    public Client toClient(ClientForm clientForm) {
        return modelMapper.map(clientForm, Client.class);
    }

    @Override
    public ClientForm toClientForm(Client client) {
        return modelMapper.map(client, ClientForm.class);
    }

    @Override
    public ClientListItem toClientListItem(Client client) {
        return modelMapper.map(client, ClientListItem.class);
    }
}
