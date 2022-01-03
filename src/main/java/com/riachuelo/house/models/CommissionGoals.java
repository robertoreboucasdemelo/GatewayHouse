package com.riachuelo.house.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommissionGoals implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Long store;
	private final String saleMonth;
	private final Long registration;
	private final String salesman;
	private final BigDecimal individualGoal;
	private final BigDecimal individualSale;
	private final BigDecimal totalGoal;
	private final BigDecimal totalSale;
	
	public CommissionGoals(CommissionGoalsBuilder builder) {
		this.store = builder.store;
		this.saleMonth = builder.saleMonth;
		this.registration = builder.registration;
		this.salesman = builder.salesman;
		this.individualGoal = builder.individualGoal;
		this.individualSale = builder.individualSale;
		this.totalGoal = builder.totalGoal;
		this.totalSale = builder.totalSale;
	}

	public Long getStore() {
		return store;
	}

	public String getSaleMonth() {
		return saleMonth;
	}

	public Long getRegistration() {
		return registration;
	}

	public String getSalesman() {
		return salesman;
	}

	public BigDecimal getIndividualGoal() {
		return individualGoal;
	}

	public BigDecimal getIndividualSale() {
		return individualSale;
	}

	public BigDecimal getTotalGoal() {
		return totalGoal;
	}

	public BigDecimal getTotalSale() {
		return totalSale;
	}

	@Override
	public String toString() {
		return "CommissionGoals [store=" + store + ", saleMonth=" + saleMonth + ", registration=" + registration
				+ ", salesman=" + salesman + ", individualGoal=" + individualGoal + ", individualSale=" + individualSale
				+ ", totalGoal=" + totalGoal + ", totalSale=" + totalSale + "]";
	}
	
	public static class CommissionGoalsBuilder{		
		private Long store;
		private String saleMonth;
		private Long registration;
		private String salesman;
		private BigDecimal individualGoal;
		private BigDecimal individualSale;
		private BigDecimal totalGoal;
		private BigDecimal totalSale;
		
		public CommissionGoalsBuilder store(Long store) {
			this.store = store;
			return this;
		}
		
		public CommissionGoalsBuilder saleMonth(String saleMonth) {
			this.saleMonth = saleMonth;
			return this;
		}
		
		public CommissionGoalsBuilder registration(Long registration) {
			this.registration = registration;
			return this;
		}
		
		public CommissionGoalsBuilder salesman(String salesman) {
			this.salesman = salesman;
			return this;
		}
		
		public CommissionGoalsBuilder individualGoal(BigDecimal individualGoal) {
			this.individualGoal = individualGoal;
			return this;
		}
		
		public CommissionGoalsBuilder individualSale(BigDecimal individualSale) {
			this.individualSale = individualSale;
			return this;
		}
		
		public CommissionGoalsBuilder totalGoal(BigDecimal totalGoal) {
			this.totalGoal = totalGoal;
			return this;
		}
		
		public CommissionGoalsBuilder totalSale(BigDecimal totalSale) {
			this.totalSale = totalSale;
			return this;
		}
		
		
		public CommissionGoals build() {
			return new CommissionGoals(this);
		}
	}
	
	

}
