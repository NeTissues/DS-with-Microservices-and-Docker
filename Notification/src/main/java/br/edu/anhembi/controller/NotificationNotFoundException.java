package br.edu.anhembi.controller;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(Long id) {
        super("Could not find Notification " + id);
    }
}