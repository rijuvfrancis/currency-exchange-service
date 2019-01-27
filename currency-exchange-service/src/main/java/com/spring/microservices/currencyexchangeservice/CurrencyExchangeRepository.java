package com.spring.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeRate, Long> {

	ExchangeRate findByFromAndTo(String from,String to);
}
