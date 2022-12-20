package com.sgenlecroyant.spring.security.api.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "/hello/{name}")
	public String sayHi(@PathVariable(name = "name", required = false) String name) {
		String response = "Hello, " + (name == null ? "people" : name);
		return response;
	}

}
