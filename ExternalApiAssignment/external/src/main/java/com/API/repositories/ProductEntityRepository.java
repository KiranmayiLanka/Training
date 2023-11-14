package com.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.entities.ProductEntity;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
	

}
