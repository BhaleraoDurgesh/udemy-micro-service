package com.bharath.springcloud.feignClient;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bharath.springcloud.model.Coupon;

//@FeignClient("COUPON-SERVICE")
@FeignClient("API-GATEWAY")
//@RibbonClient("COUPON-SERVICE")  //load balancing from client side // if we are using @feignClient(), then @feignClient() already includes @ribbonClient() also in it. so we dont need to specify externally, neither we need to add dependancy it pox.xml file
public interface CouponClient {

	
	@RequestMapping("/coupon/coupons1/{code}")  //@FeignClient("API-GATEWAY")
	public Coupon getCoupon(@PathVariable("code") String code);
}
