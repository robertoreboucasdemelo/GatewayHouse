package com.riachuelo.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.riachuelo.house.services.CommissionSalesService;

@SpringBootApplication
public class GatewayHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayHouseApplication.class, args);
	}

}
