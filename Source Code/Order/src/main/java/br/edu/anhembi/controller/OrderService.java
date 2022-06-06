package br.edu.anhembi.controller;

import br.edu.anhembi.model.OrderRegistrationRequest;
import br.edu.anhembi.model.Orders;
import br.edu.anhembi.model.ProductOrderRegistrationRequest;
import br.edu.anhembi.model.ProductOrders;
import br.edu.anhembi.model.repository.OrderRepository;
import br.edu.anhembi.model.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductOrderRepository productOrderRepository;

    public void registerOrder(OrderRegistrationRequest orderRegistrationRequest){
        Orders orders = Orders.builder()
                .totalPrice(orderRegistrationRequest.totalPrice())
                .date(LocalDateTime.now())
                .orderStatus(orderRegistrationRequest.orderStatus())
                .userId(orderRegistrationRequest.userId())
                .build();
        orderRepository.saveAndFlush(orders);
    }

    public void checkUser(ProductOrderRegistrationRequest productorderRegistrationRequest){
        ProductOrders productOrders = ProductOrders.builder()
                .unitPrice(productorderRegistrationRequest.unitPrice())
                .quantity(productorderRegistrationRequest.quantity())
                .orderStatus(productorderRegistrationRequest.orderStatus())
                .order(productorderRegistrationRequest.order())
                .addedAt(LocalDateTime.now())
                .build();
        productOrderRepository.saveAndFlush(productOrders);
    }
}
