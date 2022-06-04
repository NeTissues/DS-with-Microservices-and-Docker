package br.edu.anhembi.product.model;

public record ProductOrderRegistrationRequest(
        Long userId,
        Long productId,
        Long quantity) {
}
