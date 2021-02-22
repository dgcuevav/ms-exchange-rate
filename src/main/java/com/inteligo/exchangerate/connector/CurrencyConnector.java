package com.inteligo.exchangerate.connector;

import com.inteligo.exchangerate.model.api.currencylayer.ExchangeRate;
import reactor.core.publisher.Mono;

public interface CurrencyConnector {

  Mono<ExchangeRate> getRatesByCurrency(String currencyCode);

}
