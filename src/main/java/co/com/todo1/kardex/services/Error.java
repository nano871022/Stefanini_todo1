package co.com.todo1.kardex.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/error")
public class Error {
	
	@GetMapping
	String error() {
		return "error";
	}

}
