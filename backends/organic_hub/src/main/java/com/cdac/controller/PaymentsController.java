package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cdac.modelmvc.Payment;
import com.cdac.repository.PaymentsRepository;

@RestController
@RequestMapping("/payment")
public class PaymentsController {

    @Autowired
    private PaymentsRepository paymentRepository;

    @PostMapping("/pay")
    public Payment makePayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }
}
