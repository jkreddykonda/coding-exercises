package com.exercises.backend.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CurrencyConversionUtilTest {

	@Test
	void shouldConvertUsdToEurSuccessfully() {
		double result = CurrencyConversionUtil.convert("USD", "EUR", 100.0);
		assertEquals(91.0, result);   // Based on static conversion rate USD->EUR  = 0.91
	}

	@Test
	void shouldReturnSameAmountForUnknownCurrency() {
		double result = CurrencyConversionUtil.convert("USD", "INR", 100.0);
		assertEquals(8536.0, result);   // Based on static conversion rate USD->INR  = 85.36
	}
	
	@Test
	void shouldConvertEurToGbpSuccessfully() {
	    double result = CurrencyConversionUtil.convert("EUR", "GBP", 100.0);
	    assertEquals(100.0, result); // Based on static conversion rate EUR->GBP = 1.0
	}
	
	@Test
	void shouldReturnSameAmountWhenNoConversionRateFound() {
	    double result = CurrencyConversionUtil.convert("ABC", "XYZ", 100.0);
	    assertEquals(100.0, result); // because default rate = 1.0
	}



}
