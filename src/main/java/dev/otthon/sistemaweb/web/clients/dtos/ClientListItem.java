package dev.otthon.sistemaweb.web.clients.dtos;

import dev.otthon.sistemaweb.core.models.Client;
import dev.otthon.sistemaweb.core.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientListItem {

    private Long id;

    private String name;

    private String phone;

    private String email;

    public String getPhone() {
        return StringUtils.formatPhone(phone);
    }

    public static ClientListItem of(Client client) {
        return ClientListItem.builder()
            .id(client.getId())
            .name(client.getName())
            .email(client.getEmail())
            .phone(client.getPhone())
            .build();
    }
    
}
