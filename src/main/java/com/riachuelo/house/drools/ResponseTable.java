package com.riachuelo.house.drools;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseTable {
	
	private Long codigoRetorno;
    private String nomeAmigavel;
    private String devolutiva;
    private List<ResponseResultTable> resultados;
    
    
	public Long getCodigoRetorno() {
		return codigoRetorno;
	}
	public String getNomeAmigavel() {
		return nomeAmigavel;
	}
	public String getDevolutiva() {
		return devolutiva;
	}
	public List<ResponseResultTable> getResultados() {
		return resultados;
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
	public void setResultados(List<ResponseResultTable> resultados) {
		this.resultados = resultados;
	}
	
	@Override
	public String toString() {
		return "ResponseTable [codigoRetorno=" + codigoRetorno + ", nomeAmigavel=" + nomeAmigavel + ", devolutiva="
				+ devolutiva + ", resultados=" + resultados + "]";
	}
    
    

}
