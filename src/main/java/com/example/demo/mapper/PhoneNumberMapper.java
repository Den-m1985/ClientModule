package com.example.demo.mapper;

import com.example.demo.dto.PhoneNumberDto;
import com.example.demo.model.PhoneNumber;

public class PhoneNumberMapper {

    public static PhoneNumberDto toDto(PhoneNumber phoneNumber) {
        PhoneNumberDto dto = new PhoneNumberDto();
        dto.setId(phoneNumber.getId());
        dto.setNumber(phoneNumber.getNumber());
        return dto;
    }

    public static PhoneNumber toEntity(PhoneNumberDto dto) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(dto.getId());
        phoneNumber.setNumber(dto.getNumber());
        return phoneNumber;
    }

}
