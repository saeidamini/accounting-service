package org.play.wsi.invoice;

import org.play.wsi.error.domain.Assert;

public record Line(Quantity quantity, Fee unitPrice) {
  public Line {
    Assert.notNull("quantity", quantity);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Fee total() {
    return unitPrice.times(quantity);
  }
}
