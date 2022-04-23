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
	
	@CrossOrigin (origins = "http://localhost:3000/")
	@RequestMapping("/products")
	public List<Inventry> getAllInventry()
	{
		return productInventryService.getAllInventry();
	}
	
	@CrossOrigin (origins = "http://localhost:3000/")
	@RequestMapping(method = RequestMethod.POST, value="/products")
	public void addProduct(@RequestBody Inventry product)
	{
		productInventryService.addProduct(product);
	}
	
	@CrossOrigin (origins = "http://localhost:3000/")
	@RequestMapping(method = RequestMethod.PUT, value="/product/{id}")
	public void updateProduct(@PathVariable Integer id,@RequestBody Inventry product)
	{
		productInventryService.updateProduct(id,product);
	}
	
	@CrossOrigin (origins = "http://localhost:3000/")
	@RequestMapping(method = RequestMethod.DELETE, value="/product/{id}")
	public void DeleteProduct(@PathVariable Integer id)
	{
		productInventryService.deleteProduct(id);
	}
	
}
