package com.fabiose.springcloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiose.springcloud.domain.Currency;
import com.fabiose.springcloud.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyRest {

	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/")
	public Currency getCurrency() {
		try {
			return currencyService.getCurrency();
		} catch (Exception e) {
			e.printStackTrace();
			return new Currency();
		}
	}
	
}
