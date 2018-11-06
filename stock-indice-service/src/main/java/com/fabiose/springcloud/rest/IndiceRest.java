package com.fabiose.springcloud.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiose.springcloud.service.IndiceService;

import yahoofinance.Stock;

@RestController
@RequestMapping("/stock/indice")
public class IndiceRest {
	
	@Autowired
	private IndiceService indiceService;

	@GetMapping("/{indice}")
	public Stock getIndice(@PathVariable("indice") String indice){
		try {
			return indiceService.getIndice(indice);
		} catch (IOException e) {
			return new Stock(indice);
		}
	}
	
}
