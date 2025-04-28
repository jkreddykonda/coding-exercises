package com.exercises.backend.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercises.backend.services.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) { //Constructor Injection
		this.userService = userService;
	}

	@GetMapping("/fetch-combined")
	public CompletableFuture<String> getCombinedUserData(@RequestParam long id1, @RequestParam long id2) {
		return userService.fetchCombinedData(id1, id2);
	}

}
