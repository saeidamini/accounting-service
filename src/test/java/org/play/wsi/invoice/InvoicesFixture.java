package org.play.wsi.invoice;

import java.math.BigDecimal;
import java.util.List;

public final class InvoicesFixture {

  private InvoicesFixture() {}

  public static Invoice invoice() {
    Line firstLine = getInvoiceLine(2, 500);
    Line secoundLine = getInvoiceLine(1, 400);
    return new Invoice(List.of(firstLine, secoundLine));
  }

  public static Line getInvoiceLine(int quantity, int amount) {
    return new Line(new Quantity(quantity), getFee(amount));
  }

  public static Fee getFee(int amount) {
    return new Fee(getAmount(amount), Currency.EURO);
  }

  public static Amount getAmount(int amount) {
    return new Amount(new BigDecimal(amount));
  }
}
