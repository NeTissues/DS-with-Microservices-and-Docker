package br.edu.anhembi.model;

public enum OrderStatus {
    PENDING_APPROVAL, //Waiting for payment to be processed
    IN_PROGRESS, //Order being prepared/delivered
    COMPLETED, //Order was delivered
    CANCELLED //Order was canceled
}