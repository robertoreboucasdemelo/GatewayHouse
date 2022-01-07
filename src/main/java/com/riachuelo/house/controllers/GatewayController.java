package com.riachuelo.house.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riachuelo.house.components.Document;
import com.riachuelo.house.components.ExportExcel;
import com.riachuelo.house.components.Inconsistency;
import com.riachuelo.house.models.CommissionGoals;
import com.riachuelo.house.models.CommissionSales;
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
	
	@Autowired
	private ExportExcel exportExcel;
	
	@Autowired
	private Document document;
	
	@PostMapping
	public ResponseEntity<Document> load(){	
		
		inconsistency.getInconsistencies().clear();
			
		List<CommissionSales> listSales = commissionSalesService.read();
		List<CommissionGoals> listGoals = commissionGoalsService.read();

		gatewayService.loadEngineRules();

		if (!inconsistency.getInconsistencies().isEmpty()) {
			exportExcel.generate();
		}

		document.setQuantityReadSales(listSales.size());
		document.setQuantityReadGoals(listGoals.size());
		document.setQuantityInconsistencies(inconsistency.getInconsistencies().size());

		return ResponseEntity.ok().body(document);
		
	}

}
