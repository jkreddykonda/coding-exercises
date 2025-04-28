package com.exercises.backend.utils;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionUtil {
	 private static final Map<String, Double> conversionRates = new HashMap<>();

	    static {
	        // Predefined conversion rates: format = FROM->TO
	        conversionRates.put("SGD->USD", 0.74);
	        conversionRates.put("SGD->EUR", 0.68);
	        conversionRates.put("SGD->GBP", 0.59);

	        conversionRates.put("USD->EUR", 0.91);
	        conversionRates.put("USD->GBP", 0.78);
	        conversionRates.put("USD->INR", 85.36);
	        conversionRates.put("EUR->USD", 1.10);
	        conversionRates.put("GBP->USD", 1.28);

	        // ... add more if needed
	    }

	    public static double convert(String from, String to, double amount) {
	        String key = from.toUpperCase() + "->" + to.toUpperCase();
	        double rate = conversionRates.getOrDefault(key, 1.0);
	        return amount * rate;
	    }
}
