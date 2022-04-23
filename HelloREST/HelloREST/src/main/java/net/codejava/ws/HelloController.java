package net.codejava.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")	
	public String hello(@RequestParam(name = "name", defaultValue = "World")String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/getproduct")	
	public Product getProduct() {
		return new Product(1,"iPhone",999.99f);
	}
	
	@PostMapping("/addproduct")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
	}
	
	@GetMapping("/getproducts")	
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(1,"iPhone",999.99f));
		products.add(new Product(2,"samsung",300f));
		products.add(new Product(3,"xiaomi",400f));
		return products;
	}
	
	@PostMapping("/hello")
	public String add() {
		return "you have sent POST request";
	}
	
	@PutMapping("/hello")
	public String update() {
		return "you have sent PUT request";
	}
	
	@DeleteMapping("/hello")
	public String delete() {
		return "you have sent DELETE request";
	}
	
}
