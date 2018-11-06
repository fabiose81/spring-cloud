package com.fabiose.springcloud.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fabiose.springcloud.domain.Currency;
import com.fabiose.springcloud.domain.Rate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Service
public class CurrencyService {

	public static final String ACCESS_KEY = ""; // go to https://currencylayer.com/ to get the ACCESS_KEY
	public static final String BASE_URL = "http://apilayer.net/api/";
	public static final String ENDPOINT = "live";

	static CloseableHttpClient httpClient = HttpClients.createDefault();

	public Currency getCurrency() throws Exception {

		HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

		CloseableHttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();

		JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

		Currency currency = new Currency();
		
		currency.setSource(exchangeRates.getString("source"));
		
		Date timeStampDate = new Date((long) (exchangeRates.getLong("timestamp") * 1000));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		currency.setDateTime(dateFormat.format(timeStampDate));
		
		List<Rate> rates = new ArrayList<Rate>();
		Rate rateCAD = new Rate("USDCAD",exchangeRates.getJSONObject("quotes").getDouble("USDCAD"));
		Rate rateBRL = new Rate("USDBRL",exchangeRates.getJSONObject("quotes").getDouble("USDBRL"));
		Rate rateEUR = new Rate("USDEUR",exchangeRates.getJSONObject("quotes").getDouble("USDEUR"));
		Rate rateJPY = new Rate("USDJPY",exchangeRates.getJSONObject("quotes").getDouble("USDJPY"));
		
		rates.add(rateCAD);
		rates.add(rateBRL);
		rates.add(rateEUR);
		rates.add(rateJPY);
		
		currency.setRates(rates);

		response.close();

		return currency;
	}
}
