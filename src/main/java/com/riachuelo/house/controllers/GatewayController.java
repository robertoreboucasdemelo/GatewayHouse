package com.riachuelo.house.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riachuelo.house.components.Inconsistency;
import com.riachuelo.house.components.ItemError;
import com.riachuelo.house.services.CommissionGoalsService;
import com.riachuelo.house.services.CommissionSalesService;
import com.riachuelo.house.services.GatewayService;

@RestController
@RequestMapping(value = "/house")
public class GatewayController {
	
	@Autowired
	private CommissionSalesService commissionSalesService;
	
	@Autowired
	private CommissionGoalsService commissionGoalsService;
	
	@Autowired
	private GatewayService gatewayService;
	
	@Autowired
	private Inconsistency inconsistency;
	
	@PostMapping
	public void load(){	
		commissionSalesService.read(inconsistency);	
		commissionGoalsService.read(inconsistency);
		gatewayService.loadEngineRules();
		
		for (ItemError item : inconsistency.getInconsistencies()) {
			System.out.println("item id :" + item.getId());
			System.out.println("item description :" + item.getDescription());
		}
	}

}
