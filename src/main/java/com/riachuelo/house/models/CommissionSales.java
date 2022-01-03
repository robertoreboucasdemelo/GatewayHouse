package com.riachuelo.house.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommissionSales implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Long store;
	private final String corporateName;
	private final Long registration;
	private final String salesman;
	private final BigDecimal amount;
	private final String indicator;
	
	public CommissionSales(CommissionSalesBuilder builder) {
		this.store = builder.store;
		this.corporateName = builder.corporateName;
		this.registration = builder.registration;
		this.salesman = builder.salesman;
		this.amount = builder.amount;
		this.indicator = builder.indicator;
	}

	public Long getStore() {
		return store;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public Long getRegistration() {
		return registration;
	}

	public String getSalesman() {
		return salesman;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getIndicator() {
		return indicator;
	}

	@Override
	public String toString() {
		return "CommissionSales [store=" + store + ", corporateName=" + corporateName + ", registration=" + registration
				+ ", salesman=" + salesman + ", amount=" + amount + ", indicator=" + indicator + "]";
	}
	
	public static class CommissionSalesBuilder{
		private Long store;
		private String corporateName;
		private Long registration;
		private String salesman;
		private BigDecimal amount;
		private String indicator;
		
		public CommissionSalesBuilder store(Long store) {
			this.store = store;
			return this;
		}
		
		public CommissionSalesBuilder corporateName(String corporateName) {
			this.corporateName = corporateName;
			return this;
		}
		
		public CommissionSalesBuilder registration(Long registration) {
			this.registration = registration;
			return this;
		}
		
		public CommissionSalesBuilder salesman(String salesman) {
			this.salesman = salesman;
			return this;
		}
		
		public CommissionSalesBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}
		
		public CommissionSalesBuilder indicator(String indicator) {
			this.indicator = indicator;
			return this;
		}
		
		public CommissionSales build() {
			return new CommissionSales(this);
		}
	}
	
	
	
	
	
	

}
