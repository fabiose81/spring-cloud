package com.fabiose.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fabiose.springcloud.domain.Currency;
import com.fabiose.springcloud.domain.Indice;

@Controller
public class HomeController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/")
	public String handleRequest() {
		return "index";		
	}
	
	@GetMapping("/indice")
	public String indice(Model model) throws Exception{
		List<ServiceInstance> instances = discoveryClient.getInstances("stock-indice-service");
		
		if (instances != null && instances.size() > 0) {
			 ServiceInstance serviceInstance = instances.get(0);
			 
			 String url = serviceInstance.getUri().toString().concat("/stock/indice/^BVSP");
			 RestTemplate restTemplate = new RestTemplate();
			 
			 Indice indice = restTemplate.getForObject(url, Indice.class);
			 
			 model.addAttribute("symbol", indice.getSymbol());
			 model.addAttribute("name", indice.getName());
			 model.addAttribute("currency", indice.getCurrency());
			 model.addAttribute("stockExchange", indice.getStockExchange());
	      
		}
		
		return "index :: indice-block";	
	}
	
	@GetMapping("/currency")
	public String currency(Model model) throws Exception{
		List<ServiceInstance> instances = discoveryClient.getInstances("currency-service");
		
		if (instances != null && instances.size() > 0) {
			 ServiceInstance serviceInstance = instances.get(0);
			 
			 String url = serviceInstance.getUri().toString().concat("/currency/");
			 RestTemplate restTemplate = new RestTemplate();
			 
			 Currency currency = restTemplate.getForObject(url, Currency.class);
			 
			 model.addAttribute("source", currency.getSource());
			 model.addAttribute("dateTime", currency.getDateTime());
			 model.addAttribute("rates", currency.getRates());
	      
		}	
		
		return "index :: currency-block";	
	}

}
