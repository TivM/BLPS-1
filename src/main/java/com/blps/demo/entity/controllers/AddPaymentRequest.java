package com.blps.demo.entity.controllers;

public record AddPaymentRequest(int receive, String processor, int productOrderId) {
}
