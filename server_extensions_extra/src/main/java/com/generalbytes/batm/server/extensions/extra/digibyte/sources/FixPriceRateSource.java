package com.generalbytes.batm.server.extensions.extra.digibyte.sources;

import com.generalbytes.batm.server.extensions.Currencies;
import com.generalbytes.batm.server.extensions.IRateSource;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by b00lean on 7/31/14.
 */
public class FixPriceRateSource implements IRateSource {

  private BigDecimal rate = BigDecimal.ZERO;

  private String preferedFiatCurrency = Currencies.USD;

  public FixPriceRateSource(BigDecimal rate, String preferedFiatCurrency) {
    this.rate = rate;
    if (Currencies.EUR.equalsIgnoreCase(preferedFiatCurrency)) {
      this.preferedFiatCurrency = Currencies.EUR;
    }
    if (Currencies.USD.equalsIgnoreCase(preferedFiatCurrency)) {
      this.preferedFiatCurrency = Currencies.USD;
    }
    if (Currencies.CAD.equalsIgnoreCase(preferedFiatCurrency)) {
      this.preferedFiatCurrency = Currencies.CAD;
    }
  }

  @Override
  public Set<String> getCryptoCurrencies() {
    Set<String> result = new HashSet<String>();
    result.add(Currencies.DGB);
    return result;
  }

  @Override
  public BigDecimal getExchangeRateLast(String cryptoCurrency, String fiatCurrency) {
    if (Currencies.DGB.equalsIgnoreCase(cryptoCurrency)) {
      return rate;
    }
    return null;
  }

  @Override
  public Set<String> getFiatCurrencies() {
    Set<String> result = new HashSet<String>();
    result.add(Currencies.CAD);
    result.add(Currencies.USD);
    result.add(Currencies.EUR);
    return result;
  }

  @Override
  public String getPreferredFiatCurrency() {
    return preferedFiatCurrency;
  }

}