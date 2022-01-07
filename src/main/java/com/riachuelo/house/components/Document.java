package com.riachuelo.house.components;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer quantityReadSales;
	private Integer quantityReadGoals;
	private Integer quantityInconsistencies;
		
	public Integer getQuantityReadSales() {
		return quantityReadSales;
	}
	public Integer getQuantityReadGoals() {
		return quantityReadGoals;
	}
	public Integer getQuantityInconsistencies() {
		return quantityInconsistencies;
	}
	public void setQuantityReadSales(Integer quantityReadSales) {
		this.quantityReadSales = quantityReadSales;
	}
	public void setQuantityReadGoals(Integer quantityReadGoals) {
		this.quantityReadGoals = quantityReadGoals;
	}
	public void setQuantityInconsistencies(Integer quantityInconsistencies) {
		this.quantityInconsistencies = quantityInconsistencies;
	}
	@Override
	public String toString() {
		return "Document [quantityReadSales=" + quantityReadSales + ", quantityReadGoals=" + quantityReadGoals
				+ ", quantityInconsistencies=" + quantityInconsistencies + "]";
	}
	
	
	

}
