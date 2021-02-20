package com.inteligo.exchangerate.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExchangeRate {
  private final String source;
  private final List<Currency> rates;
}
