package dev.otthon.sistemaweb.web.employees.mappers;

import dev.otthon.sistemaweb.core.models.Address;
import dev.otthon.sistemaweb.web.employees.dtos.AddressForm;

public interface AddressMapper {

    AddressForm toAddressForm(Address address);

    Address toAddress(AddressForm addressForm);

    String formatAddress(Address address);
}
