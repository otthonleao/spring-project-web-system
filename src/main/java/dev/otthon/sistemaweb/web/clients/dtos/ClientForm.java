package dev.otthon.sistemaweb.web.clients.dtos;

import dev.otthon.sistemaweb.core.validators.ClientEmailUnique;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @Email
    @NotBlank
    @Size(max = 255)
    @ClientEmailUnique
    private String email;

    @NotEmpty
    @Size(min = 15, max = 15)
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Deve está no formato (00) 1234-5678")
    private String phone;

    
}
