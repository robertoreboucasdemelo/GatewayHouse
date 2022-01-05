package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestCalculusEngine {
	
	private final Long codigoCargo;
	private final Long matricula;
	private final Double metaLoja;
	private final Double metaVendedor;
	private final Double totalVendaLoja;
	private final Double totalVendaVendedor;
	
	
	
	public RequestCalculusEngine(RequestCalculusEngineBuider builder) {
		this.codigoCargo = builder.codigoCargo;
		this.matricula = builder.matricula;
		this.metaLoja = builder.metaLoja;
		this.metaVendedor = builder.metaVendedor;
		this.totalVendaLoja = builder.totalVendaLoja;
		this.totalVendaVendedor = builder.totalVendaVendedor;
	}
	
	public Long getCodigoCargo() {
		return codigoCargo;
	}

	public Long getMatricula() {
		return matricula;
	}

	public Double getMetaLoja() {
		return metaLoja;
	}

	public Double getMetaVendedor() {
		return metaVendedor;
	}

	public Double getTotalVendaLoja() {
		return totalVendaLoja;
	}

	public Double getTotalVendaVendedor() {
		return totalVendaVendedor;
	}

	@Override
	public String toString() {
		return "RequestCalculusEngine [codigoCargo=" + codigoCargo + ", matricula=" + matricula + ", metaLoja="
				+ metaLoja + ", metaVendedor=" + metaVendedor + ", totalVendaLoja=" + totalVendaLoja
				+ ", totalVendaVendedor=" + totalVendaVendedor + "]";
	}
	
	public static class RequestCalculusEngineBuider{		
		private Long codigoCargo;
		private Long matricula;
		private Double metaLoja;
		private Double metaVendedor;
		private Double totalVendaLoja;
		private Double totalVendaVendedor;
		
		public RequestCalculusEngineBuider codigoCargo(Long codigoCargo) {
			this.codigoCargo = codigoCargo;
			return this;
		}
		
		public RequestCalculusEngineBuider matricula(Long matricula) {
			this.matricula = matricula;
			return this;
		}
		
		public RequestCalculusEngineBuider metaLoja(Double metaLoja) {
			this.metaLoja = metaLoja;
			return this;
		}
		
		public RequestCalculusEngineBuider metaVendedor(Double metaVendedor) {
			this.metaVendedor = metaVendedor;
			return this;
		}
		
		public RequestCalculusEngineBuider totalVendaLoja(Double totalVendaLoja) {
			this.totalVendaLoja = totalVendaLoja;
			return this;
		}
		
		public RequestCalculusEngineBuider totalVendaVendedor(Double totalVendaVendedor) {
			this.totalVendaVendedor = totalVendaVendedor;
			return this;
		}
		
		public RequestCalculusEngine build() {
			return new RequestCalculusEngine(this);
		}
	}
	
	
	

}
