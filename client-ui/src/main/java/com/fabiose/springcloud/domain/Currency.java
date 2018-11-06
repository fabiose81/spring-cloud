package com.fabiose.springcloud.domain;

import java.io.Serializable;
import java.util.List;

public class Currency implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String source;
	private String dateTime;
	private List<Rate> rates;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public List<Rate> getRates() {
		return rates;
	}
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
