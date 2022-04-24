package com.Inventory.ProductInventory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.ProductInventory.Bean.Inventry;
import com.Inventory.ProductInventory.Service.ProductInventryService;

@CrossOrigin (origins = "http://localhost:3000/")
@RestController
public class ProductInventryController {

	@Autowired
	private ProductInventryService productInventryService;
	
	
	@RequestMapping("/products")
	public List<Inventry> getAllInventry()
	{
		return productInventryService.getAllInventry();
	}
	
	
	@RequestMapping("/products/{id}")
	public Inventry getProduct(@PathVariable Integer id)
	{
		Inventry product = (Inventry) productInventryService.getProduct(id);
		return product;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/add-products")
	public void addProduct(@RequestBody Inventry product)
	{
		productInventryService.addProduct(product);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@PathVariable Integer id,@RequestBody Inventry product)
	{
		productInventryService.updateProduct(id,product);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/products/{id}")
	public void DeleteProduct(@PathVariable Integer id)
	{
		productInventryService.deleteProduct(id);
	}
	
}
