package dev.otthon.sistemaweb.web.clients.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {

    private String name;

    private String email;

    private String phone;

    
}
