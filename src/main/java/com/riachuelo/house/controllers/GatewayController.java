package com.riachuelo.house.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riachuelo.house.services.CommissionGoalsService;
import com.riachuelo.house.services.CommissionSalesService;

@RestController
@RequestMapping(value = "/house")
public class GatewayController {
	
	@Autowired
	private CommissionSalesService commissionSalesService;
	
	@Autowired
	private CommissionGoalsService commissionGoalsService;
	
	@PostMapping
	public void load(){	
		commissionSalesService.read();	
		commissionGoalsService.read();
	}

}
