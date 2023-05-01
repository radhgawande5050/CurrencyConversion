package com.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
		System.out.println("currency converison service.....");
	}
	
	
	//load balancer rest template se use krna hai to pehle bean create karna padega
	/*
	 * @Bean
	 * 
	 * @LoadBalanced 
	 * public RestTemplate restTemplate() { return new RestTemplate();
	 * 
	 * }
	 */
}
