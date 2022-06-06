package br.edu.anhembi.product.model;

public record ProductRegistrationRequest (
        String name,
        String price,
        String description) {
}
