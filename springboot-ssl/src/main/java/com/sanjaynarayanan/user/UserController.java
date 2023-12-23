package com.sanjaynarayanan.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getAllUsers() {
		return new ArrayList<>(Arrays.asList("Sanjay", "Demo User"));
	}
}
