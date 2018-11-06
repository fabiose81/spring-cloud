package com.fabiose.springcloud.domain;

import java.io.Serializable;

public class Indice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String symbol;
	private String name;
	private String currency;
	private String stockExchange;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
