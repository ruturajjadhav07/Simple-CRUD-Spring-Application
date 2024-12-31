package com.ruturaj.crudApp.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ClientDto {

    @NotEmpty(message = "First Name is required")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty(message = "Last Name is required")
    private String lastName;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    

}
