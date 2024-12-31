package com.ruturaj.crudApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruturaj.crudApp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public Client findByEmail(String email);
}
