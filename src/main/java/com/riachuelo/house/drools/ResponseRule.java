package com.riachuelo.house.drools;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRule {
	
	private Long codigoRetorno;
	private String nomeAmigavel;
	private String devolutiva;
	private List<String> retornos;
	
	public Long getCodigoRetorno() {
		return codigoRetorno;
	}
	public String getNomeAmigavel() {
		return nomeAmigavel;
	}
	public String getDevolutiva() {
		return devolutiva;
	}
	public List<String> getRetornos() {
		return retornos;
	}
		
	public void setCodigoRetorno(Long codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}
	public void setNomeAmigavel(String nomeAmigavel) {
		this.nomeAmigavel = nomeAmigavel;
	}
	public void setDevolutiva(String devolutiva) {
		this.devolutiva = devolutiva;
	}
	public void setRetornos(List<String> retornos) {
		this.retornos = retornos;
	}
	
	@Override
	public String toString() {
		return "ResponseRule [codigoRetorno=" + codigoRetorno + ", nomeAmigavel=" + nomeAmigavel + ", devolutiva="
				+ devolutiva + ", retornos=" + retornos + "]";
	}
	
	

}
