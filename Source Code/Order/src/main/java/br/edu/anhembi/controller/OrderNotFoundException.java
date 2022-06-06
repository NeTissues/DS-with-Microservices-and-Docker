package br.edu.anhembi.controller;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Could not find Notification " + id);
    }
}
