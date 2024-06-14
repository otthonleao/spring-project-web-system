package dev.otthon.sistemaweb.web.clients.mappers;

import dev.otthon.sistemaweb.core.models.Client;
import dev.otthon.sistemaweb.core.utils.StringUtils;
import dev.otthon.sistemaweb.web.clients.dtos.ClientForm;
import dev.otthon.sistemaweb.web.clients.dtos.ClientListItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "dev.otthon.sistemaweb.mappers.provider",
        havingValue = "local"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toClient(ClientForm clientForm) {
        return Client.builder()
                .name(clientForm.getName())
                .email(clientForm.getEmail())
                .phone(StringUtils.cleanPhone(clientForm.getPhone()))
                .build();
    }

    @Override
    public ClientForm toClientForm(Client client) {
        return ClientForm.builder()
                .name(client.getName())
                .email(client.getEmail())
                .phone(StringUtils.formatPhone(client.getPhone()))
                .build();
    }

    @Override
    public ClientListItem toClientListItem(Client client) {
        return ClientListItem.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .build();
    }
}
