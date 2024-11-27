package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactDto {

    private Long id;
    private List<PhoneNumberDto> phoneNumbers;
    private List<EmailAddressDto> emailAddresses;

}
