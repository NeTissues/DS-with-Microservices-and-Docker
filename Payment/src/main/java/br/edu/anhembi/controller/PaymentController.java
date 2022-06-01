package br.edu.anhembi.controller;

import br.edu.anhembi.model.PaymentRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public void registerPayment(@RequestBody PaymentRegistrationRequest paymentRegistrationRequest){
        //todo: log this
        paymentService.registerPayment(paymentRegistrationRequest);
    }

    //todo: get mapping

    //todo: put mapping

    //todo: delete mapping
}
