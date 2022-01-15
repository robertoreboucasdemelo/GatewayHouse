package com.riachuelo.house.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.riachuelo.house.constants.Constants;
import com.riachuelo.house.drools.RequestCalculusEngine;
import com.riachuelo.house.drools.RequestRule;
import com.riachuelo.house.drools.Response;
import com.riachuelo.house.enums.RequestType;
import com.riachuelo.house.exceptions.ResourceNotFoundException;
import com.riachuelo.house.models.Commission;
import com.riachuelo.house.models.CommissionGoals;
import com.riachuelo.house.utils.Util;

@Service
public class GatewayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GatewayService.class);
	
	@Value("${app.brms.regracalculocomissao}")
	private String url_regracalculocomissao;

	@Value("${app.brms.regraelegibilidadecasa}")
	private String url_regraelegibilidadecasa;
	
	private List<Commission> list = null;
	
	public List<Commission> loadEngineRules(List<CommissionGoals> listGoals) {
		
		RestTemplate restTemplate = new RestTemplate();
		RequestRule<RequestCalculusEngine> engine = new RequestRule<>();	
		AtomicReference<Double> commissionAmount = new AtomicReference<>(0d);
		list = new ArrayList<>();
		
		listGoals.forEach(goals ->{
			
			Response response = null;
			
			RequestCalculusEngine request = new RequestCalculusEngine.RequestCalculusEngineBuider()
					.codigoCargo(428L)
					.matricula(goals.getRegistration())
					.metaLoja(goals.getTotalGoal().doubleValue())
					.metaVendedor(goals.getIndividualGoal().doubleValue())
					.totalVendaLoja(goals.getTotalSale().doubleValue())
					.totalVendaVendedor(goals.getIndividualSale().doubleValue())
					.build();
			
			engine.setFiltrar(RequestType.TUDO);
			engine.setVariaveis(request);
			
			try {
				Util.activeInterceptor(restTemplate, false);
				response = restTemplate.postForObject(url_regracalculocomissao, engine, Response.class);
			}catch (Exception e) {
				LOGGER.error(e.getMessage());
				throw new ResourceNotFoundException(Constants.REQUEST_ERROR);
			}
			
			if (response != null) {
				if (response.getCalculos() != null && !response.getCalculos().isEmpty()) {

					response.getCalculos().get(0).getFormulas().stream()
							.filter(formula -> Constants.DROOLS_COMMISSION.equals(formula.getFormula())).forEach(formula -> {
								commissionAmount.set(Double.valueOf(formula.getResultado()));
							});
					
					Commission commission = new Commission.CommissionBuilder()
							.registration(goals.getRegistration())
							.salesman(goals.getSalesman())
							.roleId(428L)
							.individualGoal(goals.getIndividualGoal())
							.individualSale(goals.getIndividualSale())
							.totalGoal(goals.getTotalGoal())
							.totalSale(goals.getTotalSale())
							.commissionAmount(BigDecimal.valueOf(commissionAmount.get())
									.setScale(2,RoundingMode.HALF_UP).doubleValue())
							.build();
					list.add(commission);
				}
			}	
		});
		
		return list;
		
	}

}
