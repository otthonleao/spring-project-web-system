package dev.otthon.sistemaweb.web.employees.dtos;

import dev.otthon.sistemaweb.core.enums.AddressState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressForm {

    private String city;

    private AddressState state;

    private String street;

    private String number;

    private String complement;

    private String zipCode;

    private String neighborhood;

}
