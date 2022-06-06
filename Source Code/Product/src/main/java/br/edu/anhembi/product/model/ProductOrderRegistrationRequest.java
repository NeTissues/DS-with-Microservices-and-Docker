package br.edu.anhembi.product.model;

import br.edu.anhembi.model.OrderStatus;

public record ProductOrderRegistrationRequest(
        Long userId,
        Long productId,
        OrderStatus orderStatus,
        Long quantity) {
}
