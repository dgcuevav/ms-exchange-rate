package com.inteligo.exchangerate.controller;

import com.inteligo.exchangerate.model.dto.ExchangeRateResponse;
import com.inteligo.exchangerate.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

  private static final Logger log = LoggerFactory.getLogger(ExchangeRateController.class);

  private final ExchangeRateService exchangeRateService;

  @GetMapping
  public Mono<ExchangeRateResponse> getExchangeRate(@RequestParam(value = "currencies") String currencyCode) {
    return exchangeRateService.getRates(currencyCode);
  }

}
