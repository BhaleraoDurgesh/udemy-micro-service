package com.bharath.springcloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bharath.springcloud.model.Coupon;

public interface MyRepo extends MongoRepository<Coupon, String> {

	 Coupon findByCode(String code);

}
