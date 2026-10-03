package org.handler.api.dto;

public record PaymentResponse(
        String paymentId,
        String status,
        String message
) {
}