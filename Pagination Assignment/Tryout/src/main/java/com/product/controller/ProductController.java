package com.product.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.pagination.entity.Books;
import com.product.entities.Product;
import com.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/add")
	public Product addProduct (@RequestBody Product product) {
		productservice.addProduct(product);
		return product;
	
	}
	
	@GetMapping("/allproducts")
    public Page<Product> allProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
    ) {
        return productservice.allproducts(page, size);
    }
	
//	@GetMapping("/allproducts")
//	public List<Product> allProducts(){
//		return productservice.allproducts();
//	}
	
	@GetMapping("/findbyid/{id}")
	public Product findByIdProduct (@PathVariable int id) {
		return productservice.findByIdProduct(id);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
		return productservice.updateProduct(id,product);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productservice.deleteProduct(id);
	}
	
	
	
	
	
	

}
