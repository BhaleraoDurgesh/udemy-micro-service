package com.bharath.springcloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bharath.springcloud.model.Product;

public interface ProductRepo extends MongoRepository<Product, String> {

	Product findByName(String name);
}
