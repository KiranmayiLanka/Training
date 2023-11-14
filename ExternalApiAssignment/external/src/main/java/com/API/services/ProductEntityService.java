package com.API.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.API.DTO.ProductEntityDTO;
import com.API.entities.ProductEntity;
import com.API.repositories.ProductEntityRepository;

@Service
public class ProductEntityService {
	private RestTemplate restTemplate;
	@Autowired
	private ProductEntityRepository productEntityRepo;
	private static final Logger logger=LoggerFactory.getLogger(ProductEntityService.class);
	public ProductEntityService(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}
	public ProductEntity converter(ProductEntityDTO temp) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(temp, ProductEntity.class);
	}
	public ProductEntity save(ProductEntityDTO temp) {
		ProductEntity product = converter(temp);
		HttpEntity<ProductEntity> entity = new HttpEntity<>(product);
		logger.info("Data is saved");
		ProductEntity savedObject = restTemplate.exchange("http://localhost:9630/ProductManagement/add", HttpMethod.POST, entity, ProductEntity.class).getBody();
		return productEntityRepo.save(savedObject);
	}
	
	
	public List<ProductEntity> findAllProducts(){
		logger.warn("Theres an error");
		return restTemplate.exchange("http://localhost:9630/ProductManagement/allproducts", HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductEntity>>() {}).getBody();
	}
	public ProductEntity findByID(Long id) {
		String url = "http://localhost:9630/ProductManagement/findbyid/" + id;
		return restTemplate.getForObject(url, ProductEntity.class);
	}
}
