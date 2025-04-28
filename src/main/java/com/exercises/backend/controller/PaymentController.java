package com.exercises.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercises.backend.model.Currency;
import com.exercises.backend.model.EUR;
import com.exercises.backend.model.GBP;
import com.exercises.backend.model.Payment;
import com.exercises.backend.model.USD;
import com.exercises.backend.services.payment.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	 private final PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}  
	 
	 
	  @PostMapping("/convert")
	    public String convertPayment(@RequestBody Payment payment,
	                                 @RequestParam String target) {

	        Currency currency = switch (target.toUpperCase()) {
	            case "USD" -> new USD();
	            case "EUR" -> new EUR();
	            case "GBP" -> new GBP();
	            default -> throw new IllegalArgumentException("Unsupported currency: " + target);
	        };

	        return paymentService.processPayment(payment, currency);
	 



 }

}
