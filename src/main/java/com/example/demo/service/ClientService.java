package com.example.demo.service;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ContactDto;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.mapper.ContactMapper;
import com.example.demo.model.Client;
import com.example.demo.model.Contact;
import com.example.demo.model.EmailAddress;
import com.example.demo.model.PhoneNumber;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    public Client saveClient(ClientDto clientDto) {
        Client client = ClientMapper.toEntity(clientDto);
        log.info("client {}", client.getFirstName());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        log.info("/getAllClients");
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        log.info("/getClientById");
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client addContactToClient(Long clientId, ContactDto contactDto) {
        Client client = getClientById(clientId);
        Contact contact = ContactMapper.toEntity(contactDto);
        contact.setClient(client);
        contactRepository.save(contact);
        return client;
    }

    public List<Contact> getContactsByClient(Long clientId) {
        Client client = getClientById(clientId);
        return client.getContacts();
    }

    public Set<PhoneNumber> getPhonesByClient(Long clientId) {
        List<Contact> contacts = getContactsByClient(clientId);
        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        for (Contact contact : contacts) {
            List<PhoneNumber> phoneNumber = contact.getPhoneNumbers();
            phoneNumbers.addAll(phoneNumber);
        }
        return phoneNumbers;
    }

    public Set<EmailAddress> getEmailsByClient(Long clientId) {
        List<Contact> contacts = getContactsByClient(clientId);
        Set<EmailAddress> emailAddresses = new HashSet<>();
        for (Contact contact : contacts) {
            List<EmailAddress> emailAddresse = contact.getEmailAddresses();
            emailAddresses.addAll(emailAddresse);
        }
        return emailAddresses;
    }

}
