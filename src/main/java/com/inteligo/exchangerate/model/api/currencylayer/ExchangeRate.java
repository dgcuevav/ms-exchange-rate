package com.inteligo.exchangerate.model.api.currencylayer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ExchangeRate {

  @SerializedName("success")
  @Expose
  private Boolean success;

  @SerializedName("terms")
  @Expose
  private String terms;

  @SerializedName("privacy")
  @Expose
  private String privacy;

  @SerializedName("timestamp")
  @Expose
  private Integer timestamp;

  @SerializedName("source")
  @Expose
  private String source;

  @SerializedName("quotes")
  @Expose
  private Map<String, Double> quotes;

}
