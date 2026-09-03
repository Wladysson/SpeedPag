package org.handler.application.validator;

import jakarta.enterprise.context.ApplicationScoped;

import org.handler.domain.exception.BusinessException;
import org.handler.domain.model.Payment;

import java.math.BigDecimal;

@ApplicationScoped
public class PaymentValidator {

    public void validate(Payment payment) {

        validateAccounts(payment);
        validateAmount(payment);
    }

    private void validateAccounts(Payment payment) {

        if (payment.getPayerAccountId() == null
                || payment.getReceiverAccountId() == null) {

            throw new BusinessException(
                    "Contas de origem e destino sao obrigatorias"
            );
        }

        if (payment.getPayerAccountId()
                .equals(payment.getReceiverAccountId())) {

            throw new BusinessException(
                    "Conta pagadora nao pode ser igual a conta recebedora"
            );
        }
    }

    private void validateAmount(Payment payment) {

        if (payment.getAmount() == null) {

            throw new BusinessException(
                    "Valor do pagamento obrigatorio"
            );
        }

        if (payment.getAmount()
                .compareTo(BigDecimal.ZERO) <= 0) {

            throw new BusinessException(
                    "Valor do pagamento deve ser maior que zero"
            );
        }
    }
}