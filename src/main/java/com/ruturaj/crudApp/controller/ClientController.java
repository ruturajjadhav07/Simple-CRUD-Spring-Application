package com.ruturaj.crudApp.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ruturaj.crudApp.models.Client;
import com.ruturaj.crudApp.models.ClientDto;
import com.ruturaj.crudApp.repository.ClientRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepo;

    // Get list of all clients
    @GetMapping({ "", "/" })
    public String getClients(Model model) {
        var clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("clients", clients);
        return "clients/index";
    }

    // Get form for creating a new client
    @GetMapping("/create")
    public String createClient(Model model) {
        ClientDto clientdto = new ClientDto();
        model.addAttribute("clientdto", clientdto);
        return "clients/create";
    }

    // Save a new client
    @PostMapping("/create")
    public String saveClient(@ModelAttribute("clientdto") @Valid ClientDto clientDto, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "clients/create"; // Return to form if validation fails
        }
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setCreatedAt(LocalDateTime.now());  // Set current timestamp
        clientRepo.save(client);  // Save client to the database
        return "redirect:/clients";  // Redirect to the client list page after saving
    }

    // Get form for editing an existing client
    @GetMapping("/edit/{id}")
    public String editClient(@PathVariable("id") int id, Model model) {
        Optional<Client> client = clientRepo.findById(id);
        if (client != null) {
            model.addAttribute("clientdto", client);  // Pass existing client data to the form
            return "clients/edit";  // Return to the edit form
        }
        return "redirect:/clients";  // Redirect to client list if client not found
    }

    // Update an existing client
    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable("id") int id, @ModelAttribute("clientdto") Client client) {
        client.setId(id);  // Set client ID for the update
        clientRepo.save(client);  // Save updated client to the database
        return "redirect:/clients";  // Redirect to the client list page after update
    }

    // Delete a client by ID
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientRepo.deleteById(id);  // Delete client by ID
        return "redirect:/clients";  // Redirect to the client list page after deletion
    }
}
