package com.damiano.shopEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnnableEurekaServer
public class ShopEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopEurekaServerApplication.class, args);
	}

}
