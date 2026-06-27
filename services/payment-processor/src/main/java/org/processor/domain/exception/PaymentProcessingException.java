package org.processor.domain.exception;

public class PaymentProcessingException
        extends RuntimeException {

    public PaymentProcessingException(
            String message
    ) {
        super(message);
    }

    public PaymentProcessingException(
            String message,
            Throwable cause
    ) {
        super(
                message,
                cause
        );
    }
}