package org.handler.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.application.service.PaymentCommandService;
import org.handler.application.validator.PaymentValidator;
import org.handler.domain.model.Payment;
import org.handler.domain.model.PaymentStatus;

@ApplicationScoped
public class ReceivePaymentUseCase {

    @Inject
    PaymentValidator paymentValidator;

    @Inject
    PaymentCommandService paymentCommandService;

    public Payment execute(Payment payment) {

        paymentValidator.validate(payment);

        payment.setStatus(
                PaymentStatus.PROCESSING
        );

        return paymentCommandService.create(payment);
    }
}
