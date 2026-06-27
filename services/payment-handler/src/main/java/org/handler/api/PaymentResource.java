package org.handler.api;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.handler.api.dto.PaymentRequest;
import org.handler.api.dto.PaymentResponse;
import org.handler.api.mapper.PaymentMapper;
import org.handler.application.usecase.ReceivePaymentUseCase;
import org.handler.domain.model.Payment;

@Path("/api/v1/payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    ReceivePaymentUseCase receivePaymentUseCase;

    @Inject
    PaymentMapper paymentMapper;

    @POST
    public Response createPayment(
            @Valid PaymentRequest request
    ) {

        Payment payment =
                paymentMapper.toDomain(request);

        Payment createdPayment =
                receivePaymentUseCase.execute(payment);

        PaymentResponse response =
                paymentMapper.toResponse(createdPayment);

        return Response
                .accepted(response)
                .build();
    }
}
