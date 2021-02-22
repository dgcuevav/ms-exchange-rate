package com.inteligo.exchangerate.connector;

import com.inteligo.exchangerate.model.api.currencylayer.ExchangeRate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;

@Component
@RequiredArgsConstructor
public class CurrencyConnectorImpl implements CurrencyConnector {


  @Value("${access_key}")
  private String accessKey;
  @Value("${baseurl.exchange-rate}")
  private String basUrl;

  private CurrencyApiConfiguration currencyApiConfiguration;

  @Override
  public Mono<ExchangeRate> getRatesByCurrency(String currencyCode) {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(basUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ReactorCallAdapterFactory.create())
        .build();

    currencyApiConfiguration = retrofit.create(CurrencyApiConfiguration.class);

    return currencyApiConfiguration.getAllRates(accessKey, currencyCode);
  }
}
