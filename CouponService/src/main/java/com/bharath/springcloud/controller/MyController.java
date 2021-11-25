package com.bharath.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repository.MyRepo;

@RestController
@RequestMapping("/coupon")
public class MyController {
	
	@Autowired
	private MyRepo myRepo;
	
	@PostMapping("/coupons")
	public Coupon addCoupon(@RequestBody Coupon coupon)
	{
		
		return myRepo.save(coupon);
	}
	
	@GetMapping("/coupons1/{code}")
	public Coupon getCoupon(@PathVariable("code") String code)
	{
		System.out.println("SERVER 2");
		
		return myRepo.findByCode(code);
	}

}
