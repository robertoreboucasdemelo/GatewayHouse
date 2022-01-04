package com.riachuelo.house.drools;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCalculus {
	
	private Long codigoRetorno;
    private String nomeAmigavel;
    private String devolutiva;
    private List<ResponseFormula> formulas;
    
	public Long getCodigoRetorno() {
		return codigoRetorno;
	}
	public String getNomeAmigavel() {
		return nomeAmigavel;
	}
	public String getDevolutiva() {
		return devolutiva;
	}
	public List<ResponseFormula> getFormulas() {
		return formulas;
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
	public void setFormulas(List<ResponseFormula> formulas) {
		this.formulas = formulas;
	}
	
	@Override
	public String toString() {
		return "ResponseCalculus [codigoRetorno=" + codigoRetorno + ", nomeAmigavel=" + nomeAmigavel + ", devolutiva="
				+ devolutiva + ", formulas=" + formulas + "]";
	}
    
    

}
