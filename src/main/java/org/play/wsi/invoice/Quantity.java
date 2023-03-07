package org.play.wsi.invoice;

import org.play.wsi.error.domain.Assert;

public record Quantity(Integer quantity) {
  public Quantity {
    Assert.field("quantity", quantity).min(0);
  }

  public int get() {
    return quantity;
  }
}
