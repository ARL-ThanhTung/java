package com.shop.ShopCongNghe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shop")
public class ShopCongNgheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopCongNgheApplication.class, args);
	}

}
