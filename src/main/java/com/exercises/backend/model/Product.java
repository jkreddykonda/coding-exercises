package com.exercises.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Product(
		@JsonProperty("name") String name, 
		@JsonProperty("category") String category, 
		@JsonProperty("price") double price) {

}
