package br.edu.anhembi.controller;

import br.edu.anhembi.model.Orders;
import br.edu.anhembi.model.OrderRegistrationRequest;
import br.edu.anhembi.model.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void registerOrder(OrderRegistrationRequest orderRegistrationRequest){
        Orders orders = Orders.builder()
                .totalPrice(orderRegistrationRequest.totalPrice())
                .date(LocalDateTime.now())
                .userId(orderRegistrationRequest.userId())
                .build();
        orderRepository.saveAndFlush(orders);
    }
}