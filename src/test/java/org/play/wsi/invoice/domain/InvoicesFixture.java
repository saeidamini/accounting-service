package org.play.wsi.invoice.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.play.wsi.invoice.Quantity;

public final class InvoicesFixture {

  private InvoicesFixture() {}

  public static Invoice invoice() {
    Line firstLine = getInvoiceLine(2, 500);
    Line secoundLine = getInvoiceLine(1, 400);
    return new Invoice(new InvoiceId(UUID.fromString("439cd126-8ddc-410c-b39e-542bded80b64")), List.of(firstLine, secoundLine));
  }

  public static InvoiceToCreate invoiceToCreate() {
    Line firstLine = getInvoiceLine(2, 500);
    Line secoundLine = getInvoiceLine(1, 400);
    return new InvoiceToCreate(List.of(firstLine, secoundLine));
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
