package com.inteligo.exchangerate.service.impl;

import com.inteligo.exchangerate.connector.CurrencyConnector;
import com.inteligo.exchangerate.model.Currency;
import com.inteligo.exchangerate.model.dto.ExchangeRateResponse;
import com.inteligo.exchangerate.service.ExchangeRateService;
import com.inteligo.exchangerate.mapper.ExchangeRateMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

  private static final Logger log = LoggerFactory.getLogger(ExchangeRateImpl.class);
  private final CurrencyConnector currencyConnector;

  @Override
  public Mono<ExchangeRateResponse> getRates(String currencyCode) {

    return currencyConnector.getRatesByCurrency(currencyCode)
              .map(ExchangeRateMapper::mapToExchangeRateResponse);
  }
}

