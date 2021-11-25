package com.bharath.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.feignClient.CouponClient;
import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.model.Product;
import com.bharath.springcloud.repository.ProductRepo;

@RestController
@RequestMapping("/product")
public class MyController {
	
	@Autowired
	CouponClient client;
	
	@Autowired
	ProductRepo productRepo;

	/*@PostMapping("/products")
	public Product createProduct(@RequestBody Product product)
	{
		//Coupon coupon = client.getCoupon(product.getCouponcode());
		//product.setPrice(product.getPrice() - coupon.getDiscount());
		//productRepo.save(product);
		return product;
	}
	
	@GetMapping("/products1/{name}")
	public Product createProduct(@PathVariable("name") String name)
	{
		return productRepo.findByName(name);
	}*/
	
	@PostMapping("/pr")
	public Product saveData(@RequestBody Product prod)
	{
		Coupon coupon = client.getCoupon(prod.getCouponcode());
		prod.setPrice(prod.getPrice() - coupon.getDiscount());
		
		prod.setCouponcode(null);
		
		productRepo.save(prod);
		return prod;
	}
}

