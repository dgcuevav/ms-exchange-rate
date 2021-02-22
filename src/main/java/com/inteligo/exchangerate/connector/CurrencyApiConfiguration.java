package com.inteligo.exchangerate.connector;

import com.inteligo.exchangerate.model.api.currencylayer.ExchangeRate;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyApiConfiguration {

  @GET("/live")
  Mono<ExchangeRate> getAllRates(@Query("access_key") String accessKey,
                                 @Query("currencies") String currencyCode);
}
