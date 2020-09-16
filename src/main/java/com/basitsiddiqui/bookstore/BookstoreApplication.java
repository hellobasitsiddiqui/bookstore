package com.basitsiddiqui.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@GetMapping("/")
	public String welcome(){
		return "<H1>Welcome Stranger!</H1>";
	}

	@GetMapping("/{name}")
	public String welcome(@PathVariable String name){
		return "<H1>Welcome " + name + "!</H1>";
	}


}
