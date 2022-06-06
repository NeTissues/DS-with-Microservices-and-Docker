package br.edu.anhembi.controller;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(Long id) {
        super("Could not find Payment " + id);
    }
}
