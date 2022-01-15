package com.riachuelo.house.models;

import java.math.BigDecimal;

public class Commission {
	
	private final Long registration;
	private final String salesman;
	private final Long roleId;
	private final BigDecimal individualGoal;
	private final BigDecimal individualSale;
	private final BigDecimal totalGoal;
	private final BigDecimal totalSale;
	private final Double commissionAmount;
	
	
	public Commission(CommissionBuilder builder) {
		this.registration = builder.registration;
		this.salesman = builder.salesman;
		this.roleId = builder.roleId;
		this.individualGoal = builder.individualGoal;
		this.individualSale = builder.individualSale;
		this.totalGoal = builder.totalGoal;
		this.totalSale = builder.totalSale;
		this.commissionAmount = builder.commissionAmount;
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


	public Double getCommissionAmount() {
		return commissionAmount;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	
	@Override
	public String toString() {
		return "Commission [registration=" + registration + ", salesman=" + salesman + ", roleId=" + roleId
				+ ", individualGoal=" + individualGoal + ", individualSale=" + individualSale + ", totalGoal="
				+ totalGoal + ", totalSale=" + totalSale + ", commissionAmount=" + commissionAmount + "]";
	}

	public static class CommissionBuilder{		
		private  Long registration;
		private  String salesman;
		private  Long roleId;
		private  BigDecimal individualGoal;
		private  BigDecimal individualSale;
		private  BigDecimal totalGoal;
		private  BigDecimal totalSale;
		private  Double commissionAmount;
		
	
		public CommissionBuilder registration(Long registration) {
			this.registration = registration;
			return this;
		}
		
		public CommissionBuilder salesman(String salesman) {
			this.salesman = salesman;
			return this;
		}
		
		public CommissionBuilder roleId(Long roleId) {
			this.roleId = roleId;
			return this;
		}
		
		public CommissionBuilder individualGoal(BigDecimal individualGoal) {
			this.individualGoal = individualGoal;
			return this;
		}
		
		public CommissionBuilder individualSale(BigDecimal individualSale) {
			this.individualSale = individualSale;
			return this;
		}
		
		public CommissionBuilder totalGoal(BigDecimal totalGoal) {
			this.totalGoal = totalGoal;
			return this;
		}
		
		public CommissionBuilder totalSale(BigDecimal totalSale) {
			this.totalSale = totalSale;
			return this;
		}
		
		public CommissionBuilder commissionAmount(Double commissionAmount) {
			this.commissionAmount = commissionAmount;
			return this;
		}
		
		
		public Commission build() {
			return new Commission(this);
		}
	}

	

}
