package br.edu.anhembi.controller;

import br.edu.anhembi.model.OrderRegistrationRequest;
import br.edu.anhembi.model.Orders;
import br.edu.anhembi.model.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping
    public void registerOrder(@RequestBody OrderRegistrationRequest orderRegistrationRequest){
        //todo: log this
        orderService.registerOrder(orderRegistrationRequest);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping(path = "{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable(value = "orderId") Long orderId) throws OrderNotFoundException {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        return ResponseEntity.ok().body(orders);
    }

    @PutMapping(path = "{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable(value = "orderId") Long orderId,
                                              @Valid @RequestBody Orders orderDetails) throws OrderNotFoundException {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        orders.setUserId(orderDetails.getUserId());
        orders.setTotalPrice(orderDetails.getTotalPrice());

        final Orders updatedOrder = orderRepository.save(orders);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable(value = "orderId") Long orderId) throws OrderNotFoundException {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        orderRepository.delete(orders);
    }
}