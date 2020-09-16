package com.basitsiddiqui.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@GetMapping("/")
	public String welcome(){
		return "<H1>Welcome!</H1>";
	}

	@GetMapping("/Raj")
	public String welcomeRaj(){
		return "<H1>Welcome Raj!</H1>";
	}

	@GetMapping("/Pranav")
	public String welcomePranav(){
		return "<H1>Welcome Pranav!</H1>";
	}

}
