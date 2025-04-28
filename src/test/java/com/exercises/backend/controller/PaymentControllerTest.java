package com.exercises.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.exercises.backend.services.payment.PaymentService;

@WebMvcTest(PaymentController.class) 
public class PaymentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PaymentService paymentService;

	@Test
	@DisplayName("Should convert currency successfully")
	void testConvertCurrencySuccess() throws Exception {
		// Arrange (mock the service)
		Mockito.when(paymentService.processPayment(Mockito.any(), Mockito.any()))
				.thenReturn("Converting 100.0 USD to USD: 100.0");

		// Act & Assert
		mockMvc.perform(post("/api/payments/convert?target=USD").contentType(MediaType.APPLICATION_JSON)
				.content("{\"amount\":100.0,\"currency\":\"USD\"}")) // Assuming your Payment payload
				.andExpect(status().isOk()).andExpect(content().string("Converting 100.0 USD to USD: 100.0"));
	}

	@Test
	@DisplayName("Should return error for invalid currency")
	void testConvertCurrencyFailure() throws Exception {
		// Arrange (mock the service to throw exception)
		Mockito.when(paymentService.processPayment(Mockito.any(), Mockito.any()))
				.thenThrow(new IllegalArgumentException("Unsupported currency"));

		// Act & Assert
		mockMvc.perform(post("/api/payments/convert?target=INR")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content("{\"amount\":100.0,\"currency\":\"USD\"}"))  // Assuming this as body
		    .andExpect(status().isBadRequest())
		    .andExpect(jsonPath("$.error").value("Unsupported currency: INR"));
	}

}
