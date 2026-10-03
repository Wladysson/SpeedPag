package org.handler.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequest(

        @NotBlank(message = "Conta pagadora obrigatoria")
        String payerAccountId,

        @NotBlank(message = "Conta recebedora obrigatoria")
        String receiverAccountId,

        @NotNull(message = "Valor obrigatorio")
        @DecimalMin(
                value = "0.01",
                message = "Valor deve ser maior que zero"
        )
        BigDecimal amount,

        String description
) {
}