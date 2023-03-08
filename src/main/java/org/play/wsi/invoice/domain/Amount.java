package org.play.wsi.invoice.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.play.wsi.error.domain.Assert;
import org.play.wsi.invoice.Quantity;

public record Amount(BigDecimal amount) {
  public static final Amount ZERO = new Amount(BigDecimal.ZERO);

  public Amount(BigDecimal amount) {
    Assert.field("amount", amount).notNull().min(0);
    this.amount = amount.setScale(2, RoundingMode.HALF_UP);
  }

  public Amount times(Quantity quantity) {
    Assert.notNull("quantity", quantity);
    return new Amount(amount.multiply(new BigDecimal(quantity.get())));
  }

  public Amount add(Amount other) {
    Assert.notNull("other", other);
    return new Amount(amount().add(other.amount));
  }
}
