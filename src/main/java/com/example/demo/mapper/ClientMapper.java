package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.model.Client;

import java.util.stream.Collectors;

public class ClientMapper {

    public static ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setMiddleName(client.getMiddleName());
        dto.setLastName(client.getLastName());
        if (client.getContacts() != null) {
            dto.setContacts(client.getContacts().stream()
                    .map(ContactMapper::toDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Client toEntity(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setFirstName(dto.getFirstName());
        client.setMiddleName(dto.getMiddleName());
        client.setLastName(dto.getLastName());
        if (dto.getContacts() != null) {
            client.setContacts(dto.getContacts().stream()
                    .map(ContactMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return client;
    }

}
