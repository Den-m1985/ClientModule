package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<ContactDto> contacts;

}
