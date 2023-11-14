package com.product.service;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.product.entities.Product;
import com.product.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productrepository;
	
	public Product addProduct (Product product)
	{
		return productrepository.save(product);
	}

	public Page<Product> allproducts(int page, int size) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("price")));
		return productrepository.findAll(pageable);
	}

	public Product findByIdProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productrepository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}

	public Product updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		Product currentProduct = productrepository.findById(id).get();
		currentProduct.setName(product.getName());
		currentProduct.setQuantity(product.getQuantity());
		currentProduct.setPrice(product.getPrice());
		return productrepository.save(currentProduct);
		
		
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productrepository.deleteById(id);
		
		
	}
	
	
	
	
	

}
