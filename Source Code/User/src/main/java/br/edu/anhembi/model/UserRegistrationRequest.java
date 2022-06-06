package br.edu.anhembi.model;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        String email) {
}