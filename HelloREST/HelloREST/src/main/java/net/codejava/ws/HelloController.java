package net.codejava.ws;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")	
	public String hello(@RequestParam(name = "name", defaultValue = "World")String name) {
		return "Hello " + name;
	}
	
	@PostMapping("/hello")
	public String add() {
		return "you have sent POST request";
	}
	
	@PutMapping("/hello")
	public String update() {
		return "you have sent POST request";
	}
	
	@DeleteMapping("/hello")
	public String add() {
		return "you have sent POST request";
	}
	
}
