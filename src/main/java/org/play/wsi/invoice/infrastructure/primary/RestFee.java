package org.play.wsi.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import org.play.wsi.invoice.domain.Amount;
import org.play.wsi.invoice.domain.Currency;
import org.play.wsi.invoice.domain.Fee;

public class RestFee {

  private final BigDecimal amount;
  private final Currency currency;

  public RestFee(@JsonProperty("amount") BigDecimal amount, @JsonProperty("currency") Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public static RestFee from(Fee fee) {
    return new RestFee(fee.amount().get(), fee.currency());
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Fee toDomain() {
    return new Fee(new Amount(amount), currency);
  }
}
