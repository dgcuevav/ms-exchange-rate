package com.inteligo.exchangerate.service.impl;

import com.inteligo.exchangerate.model.Currency;
import com.inteligo.exchangerate.model.dto.ExchangeRateResponse;
import com.inteligo.exchangerate.service.ExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeRateImpl implements ExchangeRateService {

  private static final Logger log = LoggerFactory.getLogger(ExchangeRateImpl.class);

  @Override
  public Mono<ExchangeRateResponse> getRates() {

    List<Currency> currencies = new ArrayList<>();
    currencies.add(Currency.builder().code("USDAED").rate(3.67315).build());
    currencies.add(Currency.builder().code("USDANG").rate(1.790403).build());

    ExchangeRateResponse rate = ExchangeRateResponse.builder()
        .source("USD")
        .currencies(currencies)
        .build();
    log.info(rate.toString());
    return Mono.just(rate);
  }
}

