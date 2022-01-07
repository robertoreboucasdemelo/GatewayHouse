package com.riachuelo.house.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riachuelo.house.components.ExportExcel;
import com.riachuelo.house.components.Inconsistency;
import com.riachuelo.house.services.CommissionGoalsService;
import com.riachuelo.house.services.CommissionSalesService;
import com.riachuelo.house.services.GatewayService;
import com.riachuelo.house.utils.Util;

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
	
	@Autowired
	private ExportExcel exportExcel;
	
	@PostMapping
	public void load(){	
		commissionSalesService.read();	
		commissionGoalsService.read();
		gatewayService.loadEngineRules();
		
		if (!inconsistency.getInconsistencies().isEmpty()) {
			exportExcel.generate();
		}
		
	}

}
