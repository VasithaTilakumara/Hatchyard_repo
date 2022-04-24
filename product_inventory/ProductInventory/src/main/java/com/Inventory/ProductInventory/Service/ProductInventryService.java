package com.Inventory.ProductInventory.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.ProductInventory.Bean.Inventry;
import com.Inventory.ProductInventory.Repository.ProductInventryRepository;

@Service
public class ProductInventryService {

	@Autowired
	public ProductInventryRepository inventryRepo;
	
	public List<Inventry> getAllInventry()
	{
		List<Inventry> product = new ArrayList<>();
		inventryRepo.findAll().forEach(product::add);
		return product;
	}
	
	public Inventry getProduct(Integer id) {
		Optional<Inventry> product =  inventryRepo.findById(id);
		Inventry inventry = product.get();
		return inventry;
		
	}

	public void addProduct(Inventry inventry) {
		inventryRepo.save(inventry);
		
	}

	public void updateProduct(Integer id, Inventry product) {
		inventryRepo.save(product);
		
	}

	public void deleteProduct(Integer id) {
		inventryRepo.deleteById(id);
		
	}
}
