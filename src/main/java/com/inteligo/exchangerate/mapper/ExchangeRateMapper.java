package com.inteligo.exchangerate.mapper;

import com.inteligo.exchangerate.model.Currency;
import com.inteligo.exchangerate.model.api.currencylayer.ExchangeRate;
import com.inteligo.exchangerate.model.dto.ExchangeRateResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ExchangeRateMapper {

  public static ExchangeRateResponse mapToExchangeRateResponse(ExchangeRate exchangeRate) {

    List<Currency> currencyList = new ArrayList<>();
    exchangeRate.getQuotes().forEach(
        (s, aDouble) -> currencyList.add(Currency.builder()
                        .code(s)
                        .rate(aDouble)
                        .build()));

    return ExchangeRateResponse.builder()
        .source(exchangeRate.getSource())
        .currencies(currencyList)
        .build();

  }

}
