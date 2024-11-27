package com.example.demo.mapper;

import com.example.demo.dto.EmailAddressDto;
import com.example.demo.model.EmailAddress;

public class EmailAddressMapper {

    public static EmailAddressDto toDto(EmailAddress emailAddress) {
        EmailAddressDto dto = new EmailAddressDto();
        dto.setId(emailAddress.getId());
        dto.setEmail(emailAddress.getEmail());
        return dto;
    }

    public static EmailAddress toEntity(EmailAddressDto dto) {
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setId(dto.getId());
        emailAddress.setEmail(dto.getEmail());
        return emailAddress;
    }

}
