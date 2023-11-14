package com.API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.DTO.ProductEntityDTO;
import com.API.entities.ProductEntity;
import com.API.services.ProductEntityService;

@RestController
@RequestMapping("/external-api")
public class ProductEntityController {
	@Autowired
	private ProductEntityService service;
	
	@PostMapping("/save")
	public ProductEntity save(@RequestBody ProductEntityDTO temp) {
		return service.save(temp);
	}
	
	@GetMapping("/findAll")
	public List<ProductEntity> findAll(){
		return service.findAllProducts();
	}
	
	@GetMapping("/findById/{id}")
	public ProductEntity findById(@PathVariable Long id) {
		return service.findByID(id);
	}
}
