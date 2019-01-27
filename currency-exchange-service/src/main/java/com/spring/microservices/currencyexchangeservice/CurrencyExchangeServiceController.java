package com.spring.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyExchangeServiceController {

	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeRate getExchangeRate(@PathVariable String from, @PathVariable String to) {
		// ExchangeRate exchangeRate = new ExchangeRate(1000l, from, to,
		// BigDecimal.valueOf(65));
		ExchangeRate exchangeRate = currencyExchangeRepository.findByFromAndTo(from, to);
		exchangeRate.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("getExchangeRate {}",exchangeRate);
		return exchangeRate;
	}
}
