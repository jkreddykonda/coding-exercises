package com.exercises.backend.services.payment;

import org.springframework.stereotype.Service;

import com.exercises.backend.model.Currency;
import com.exercises.backend.model.Payment;
import com.exercises.backend.utils.CurrencyConversionUtil;


@Service
public class PaymentService {
	
	  public String processPayment(Payment payment, Currency targetCurrency) {
	        String target = targetCurrency.getClass().getSimpleName(); // e.g., "USD"
	        double convertedAmount = CurrencyConversionUtil.convert(payment.currency(), target, payment.amount());

	        return "Converting " + payment.amount() + " " + payment.currency() +
	                " to " + target + ": " + convertedAmount;
	    }

}
