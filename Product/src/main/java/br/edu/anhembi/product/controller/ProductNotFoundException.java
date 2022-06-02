package br.edu.anhembi.product.controller;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not find Product " + id);
    }
}
