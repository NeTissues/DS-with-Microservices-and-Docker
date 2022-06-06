package br.edu.anhembi.controller;

import br.edu.anhembi.model.Payment;
import br.edu.anhembi.model.PaymentRegistrationRequest;
import br.edu.anhembi.model.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    @PostMapping
    public void registerPayment(@RequestBody PaymentRegistrationRequest paymentRegistrationRequest){
        //todo: log this
        paymentService.registerPayment(paymentRegistrationRequest);
    }
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping(path = "{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "paymentId") Long paymentId) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException(paymentId));
        return ResponseEntity.ok().body(payment);
    }

    @PutMapping(path = "{paymentId}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "paymentId") Long paymentId,
                                                 @Valid @RequestBody Payment paymentDetails) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException(paymentId));

        payment.setOrderId(paymentDetails.getOrderId());
        payment.setUserId(paymentDetails.getUserId());
        payment.setPaymentStatus(paymentDetails.getPaymentStatus());
        payment.setPaymentMethod((paymentDetails.getPaymentMethod()));
        payment.setPaymentTime(LocalDateTime.now());

        final Payment updatedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping(path = "{paymentId}")
    public void deletePayment(@PathVariable(value = "paymentId") Long paymentId) throws PaymentNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException(paymentId));
        paymentRepository.delete(payment);
    }

    @PatchMapping(path = "{paymentId}/{paymentMethod}")
    public ResponseEntity<Payment> updatePaymentPartially(@PathVariable Long paymentId, @PathVariable Double paymentMethod) {
        try {            Payment payment = paymentRepository.findById(paymentId).get();
            payment.setPaymentMethod(String.valueOf(paymentMethod));
            return new ResponseEntity<Payment>(paymentRepository.save(payment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
