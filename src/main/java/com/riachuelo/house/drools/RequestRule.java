package com.riachuelo.house.drools;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.riachuelo.house.enums.RequestType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestRule<T> {
	
	private RequestType filtrar = RequestType.TUDO;
	private T variaveis;
	
	public RequestType getFiltrar() {
		return filtrar;
	}
	public void setFiltrar(RequestType filtrar) {
		this.filtrar = filtrar;
	}
	public T getVariaveis() {
		return variaveis;
	}
	public void setVariaveis(T variaveis) {
		this.variaveis = variaveis;
	}
	
	

}
