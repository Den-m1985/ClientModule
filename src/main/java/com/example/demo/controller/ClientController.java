package com.example.demo.controller;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ContactDto;
import com.example.demo.model.Client;
import com.example.demo.model.Contact;
import com.example.demo.model.EmailAddress;
import com.example.demo.model.PhoneNumber;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/save/client")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.saveClient(clientDto);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/all/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/all/contacts")
    public ResponseEntity<List<Contact>> getAllClients(@PathVariable Long clientId) {
        List<Contact> contacts = clientService.getContactsByClient(clientId);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/all/phones")
    public ResponseEntity<Set<PhoneNumber>> getAllPhonesByClient(@PathVariable Long clientId) {
        Set<PhoneNumber> contacts = clientService.getPhonesByClient(clientId);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/all/emails")
    public ResponseEntity<Set<EmailAddress>> getAllEmailsByClient(@PathVariable Long clientId) {
        Set<EmailAddress> contacts = clientService.getEmailsByClient(clientId);
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long clientId) {
        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/save/contact")
    public ResponseEntity<Client> addContactToClient(@RequestBody Long clientId, ContactDto contactDto) {
        Client client = clientService.addContactToClient(clientId, contactDto);
        return ResponseEntity.ok(client);
    }

}
