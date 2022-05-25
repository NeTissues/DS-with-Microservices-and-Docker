package br.edu.anhembi.model;

public record UserRegistrationRequest(
        String firstName,
        String secondName,
        String username,
        String password,
        String email) {
}