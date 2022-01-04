package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseFormula {
	
	private String formula;
	private String resultado;
	private String devolutiva;
	private String erro;

	public String getFormula() {
		return formula;
	}

	public String getResultado() {
		return resultado;
	}

	public String getDevolutiva() {
		return devolutiva;
	}

	public String getErro() {
		return erro;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setDevolutiva(String devolutiva) {
		this.devolutiva = devolutiva;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	@Override
	public String toString() {
		return "ResponseFormula [formula=" + formula + ", resultado=" + resultado + ", devolutiva=" + devolutiva
				+ ", erro=" + erro + "]";
	}
	 
	

}
