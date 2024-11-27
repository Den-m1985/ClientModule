package com.example.demo.mapper;

import com.example.demo.dto.ContactDto;
import com.example.demo.model.Contact;

import java.util.stream.Collectors;

public class ContactMapper {

    public static ContactDto toDto(Contact contact) {
        ContactDto dto = new ContactDto();
        dto.setId(contact.getId());
        if (contact.getPhoneNumbers() != null) {
            dto.setPhoneNumbers(contact.getPhoneNumbers().stream()
                    .map(PhoneNumberMapper::toDto)
                    .collect(Collectors.toList()));
        }
        if (contact.getEmailAddresses() != null) {
            dto.setEmailAddresses(contact.getEmailAddresses().stream()
                    .map(EmailAddressMapper::toDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Contact toEntity(ContactDto dto) {
        Contact contact = new Contact();
        contact.setId(dto.getId());
        if (dto.getPhoneNumbers() != null) {
            contact.setPhoneNumbers(dto.getPhoneNumbers().stream()
                    .map(PhoneNumberMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        if (dto.getEmailAddresses() != null) {
            contact.setEmailAddresses(dto.getEmailAddresses().stream()
                    .map(EmailAddressMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return contact;
    }
}
