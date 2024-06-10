package dev.otthon.sistemaweb.web.clients.mappers;

import dev.otthon.sistemaweb.core.models.Client;
import dev.otthon.sistemaweb.web.clients.dtos.ClientForm;
import dev.otthon.sistemaweb.web.clients.dtos.ClientListItem;

public interface ClientMapper {

    Client toClient(ClientForm clientForm);

    ClientForm toClientForm(Client client);

    ClientListItem toClientListItem(Client client);

}
