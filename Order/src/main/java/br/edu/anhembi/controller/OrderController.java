package br.edu.anhembi.controller;

import br.edu.anhembi.model.OrderRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void registerOrder(@RequestBody OrderRegistrationRequest orderRegistrationRequest){
        //todo: log this
        orderService.registerOrder(orderRegistrationRequest);
    }

    //todo: get mapping

    //todo: put mapping

    //todo: delete mapping
}