package com.xili.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductServiceApplication {

//	@Bean(value = "restTemplate")
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}


	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
