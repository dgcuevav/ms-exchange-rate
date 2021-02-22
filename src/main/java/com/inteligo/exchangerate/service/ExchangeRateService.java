package com.inteligo.exchangerate.service;

import com.inteligo.exchangerate.model.dto.ExchangeRateResponse;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

  Mono<ExchangeRateResponse> getRates(String currencyCode);
}
