package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseProcedures {
	
	private Long codigoRetorno;
	private String nomeAmigavel;
	private String devolutiva;
	private Object raiz;
	
	public Long getCodigoRetorno() {
		return codigoRetorno;
	}
	public String getNomeAmigavel() {
		return nomeAmigavel;
	}
	public String getDevolutiva() {
		return devolutiva;
	}
	public Object getRaiz() {
		return raiz;
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
	public void setRaiz(Object raiz) {
		this.raiz = raiz;
	}
	
	@Override
	public String toString() {
		return "ResponseProcedures [codigoRetorno=" + codigoRetorno + ", nomeAmigavel=" + nomeAmigavel + ", devolutiva="
				+ devolutiva + ", raiz=" + raiz + "]";
	}
	
	

}
