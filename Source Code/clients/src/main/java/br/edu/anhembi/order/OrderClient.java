package br.edu.anhembi.order;

import br.edu.anhembi.model.OrderStatus;
import br.edu.anhembi.model.Orders;
import br.edu.anhembi.model.ProductOrderRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "localhost:8081")
public interface OrderClient {

    @GetMapping(path = "api/v1/order/userId/{userId}/{orderStatus}")
    ResponseEntity<Orders> findTopByUserIdAndOrderStatus(@PathVariable(value = "userId") Long userId, @PathVariable(value = "orderStatus") OrderStatus orderStatus);

    @PutMapping(path = "api/v1/order/product-order/{orderId}")
    ResponseEntity<Orders> updateProductOrder(@PathVariable(value = "orderId") Long orderId,@RequestBody ProductOrderRegistrationRequest orderDetails);

    @PostMapping(path = "api/v1/order/product-order")
    ResponseEntity<Orders> createProductOrder(@RequestBody ProductOrderRegistrationRequest orderDetails);
}