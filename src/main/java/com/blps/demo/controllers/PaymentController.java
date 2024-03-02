package com.blps.demo.controllers;

import com.blps.demo.entity.Payment;
import com.blps.demo.entity.controllers.AddPaymentRequest;
import com.blps.demo.entity.controllers.AddPaymentResponse;
import com.blps.demo.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    @PostMapping("/payment")
    public AddPaymentResponse addPayment(@RequestBody AddPaymentRequest addPaymentRequest){
        Payment payment = paymentService.addPayment(addPaymentRequest.receive(),
                        addPaymentRequest.processor(),
                        addPaymentRequest.productOrderId());
        return new AddPaymentResponse(payment.getReceive(), payment.getChange(), payment.getProcessor());
    }
}
