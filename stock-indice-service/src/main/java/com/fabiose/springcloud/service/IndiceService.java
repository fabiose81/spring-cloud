package com.fabiose.springcloud.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class IndiceService {
	
	public Stock getIndice(String indice) throws IOException{
		return YahooFinance.get(indice);
	}

}
