package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseResultTable {
	
	private String resultado;
	private String saida;
	
	public String getResultado() {
		return resultado;
	}
	public String getSaida() {
		return saida;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	@Override
	public String toString() {
		return "ResponseResultTable [resultado=" + resultado + ", saida=" + saida + "]";
	}
	
	
	
}
