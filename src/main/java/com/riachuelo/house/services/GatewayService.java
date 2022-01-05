package com.riachuelo.house.services;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.riachuelo.house.drools.RequestCalculusEngine;
import com.riachuelo.house.drools.RequestRule;
import com.riachuelo.house.drools.Response;
import com.riachuelo.house.enums.RequestType;
import com.riachuelo.house.utils.Util;

@Service
public class GatewayService {
	
	@Value("${app.brms.regracalculocomissao}")
	private String url_regracalculocomissao;

	@Value("${app.brms.regraelegibilidadecasa}")
	private String url_regraelegibilidadecasa;
	
	public void loadEngineRules() {
		
		RestTemplate restTemplate = new RestTemplate();
		RequestRule<RequestCalculusEngine> engine = new RequestRule<>();
		Response response = null;
		AtomicReference<Double> commissionAmount = new AtomicReference<>(0d);
	
		RequestCalculusEngine request = new RequestCalculusEngine.RequestCalculusEngineBuider()
				.codigoCargo(428L)
				.matricula(10L)
				.metaLoja(1000d)
				.metaVendedor(500d)
				.totalVendaLoja(800d)
				.totalVendaVendedor(400d)
				.build();
		
		engine.setFiltrar(RequestType.TUDO);
		engine.setVariaveis(request);
		
		try {
			Util.ativaInterceptor(restTemplate, false);
			response = restTemplate.postForObject(url_regracalculocomissao, engine, Response.class);
		}catch (Exception e) {
			System.out.println("Error " + e);
		}
	
		if (response != null) {
			if (response.getCalculos() != null && !response.getCalculos().isEmpty()) {

				response.getCalculos().get(0).getFormulas().stream()
						.filter(formula -> "Valor Comissao: ".equals(formula.getFormula())).forEach(formula -> {
							commissionAmount.set(Double.valueOf(formula.getResultado()));
						});
			}
		}
		
		
		
		
	}

}
