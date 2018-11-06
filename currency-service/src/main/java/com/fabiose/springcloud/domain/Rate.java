package com.fabiose.springcloud.domain;

import java.io.Serializable;

public class Rate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private double value;

	public Rate(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public Rate() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}