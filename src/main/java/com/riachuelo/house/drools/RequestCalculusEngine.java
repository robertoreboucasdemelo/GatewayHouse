package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestCalculusEngine {
	
	private Long codigoCargo;
	private Long matricula;
	private Double metaLoja;
	private Double metaVendedor;
	private Double totalVendaLoja;
	private Double totalVendaVendedor;
	
	public Long getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(Long codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public Double getMetaLoja() {
		return metaLoja;
	}
	public void setMetaLoja(Double metaLoja) {
		this.metaLoja = metaLoja;
	}
	public Double getMetaVendedor() {
		return metaVendedor;
	}
	public void setMetaVendedor(Double metaVendedor) {
		this.metaVendedor = metaVendedor;
	}
	public Double getTotalVendaLoja() {
		return totalVendaLoja;
	}
	public void setTotalVendaLoja(Double totalVendaLoja) {
		this.totalVendaLoja = totalVendaLoja;
	}
	public Double getTotalVendaVendedor() {
		return totalVendaVendedor;
	}
	public void setTotalVendaVendedor(Double totalVendaVendedor) {
		this.totalVendaVendedor = totalVendaVendedor;
	}
	
	@Override
	public String toString() {
		return "RequestCalculusEngine [codigoCargo=" + codigoCargo + ", matricula=" + matricula + ", metaLoja="
				+ metaLoja + ", metaVendedor=" + metaVendedor + ", totalVendaLoja=" + totalVendaLoja
				+ ", totalVendaVendedor=" + totalVendaVendedor + "]";
	}
	
	
	

}
