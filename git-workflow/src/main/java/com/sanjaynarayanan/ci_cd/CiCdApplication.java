package com.sanjaynarayanan.ci_cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CiCdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiCdApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcomeCI() {
		return "Welcome to CI";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome User123445679";
	}

}
