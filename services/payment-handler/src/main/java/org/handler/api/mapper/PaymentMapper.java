package org.handler.api.mapper;

import jakarta.enterprise.context.ApplicationScoped;

import org.handler.api.dto.PaymentRequest;
import org.handler.api.dto.PaymentResponse;
import org.handler.domain.model.Payment;
import org.handler.domain.model.PaymentStatus;

@ApplicationScoped
public class PaymentMapper {

    public Payment toDomain(PaymentRequest request) {

        return Payment.builder()
                .payerAccountId(request.payerAccountId())
                .receiverAccountId(request.receiverAccountId())
                .amount(request.amount())
                .description(request.description())
                .status(PaymentStatus.PROCESSING)
                .build();
    }

    public PaymentResponse toResponse(Payment payment) {

        return new PaymentResponse(
                payment.getId(),
                payment.getStatus().name(),
                "Pagamento recebido e enviado para processamento"
        );
    }
}