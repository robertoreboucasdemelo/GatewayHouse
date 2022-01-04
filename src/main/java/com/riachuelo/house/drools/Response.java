package com.riachuelo.house.drools;

import java.util.List;
import java.util.Queue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private String rastreio;
    private String bom;
    private Object variaveis;
    private List<ResponseRule> regras;
    private List<ResponseCalculus> calculos;
    private List<ResponseTable> tabelas;
    private Queue<ResponseProcedures> procedimentos;
    
	public String getRastreio() {
		return rastreio;
	}
	public String getBom() {
		return bom;
	}
	public Object getVariaveis() {
		return variaveis;
	}
	public List<ResponseRule> getRegras() {
		return regras;
	}
	public List<ResponseCalculus> getCalculos() {
		return calculos;
	}
	public List<ResponseTable> getTabelas() {
		return tabelas;
	}
	public Queue<ResponseProcedures> getProcedimentos() {
		return procedimentos;
	}
		
	public void setRastreio(String rastreio) {
		this.rastreio = rastreio;
	}
	public void setBom(String bom) {
		this.bom = bom;
	}
	public void setVariaveis(Object variaveis) {
		this.variaveis = variaveis;
	}
	public void setRegras(List<ResponseRule> regras) {
		this.regras = regras;
	}
	public void setCalculos(List<ResponseCalculus> calculos) {
		this.calculos = calculos;
	}
	public void setTabelas(List<ResponseTable> tabelas) {
		this.tabelas = tabelas;
	}
	public void setProcedimentos(Queue<ResponseProcedures> procedimentos) {
		this.procedimentos = procedimentos;
	}
	
	@Override
	public String toString() {
		return "Response [rastreio=" + rastreio + ", bom=" + bom + ", variaveis=" + variaveis + ", regras=" + regras
				+ ", calculos=" + calculos + ", tabelas=" + tabelas + ", procedimentos=" + procedimentos + "]";
	}
    
    
}
