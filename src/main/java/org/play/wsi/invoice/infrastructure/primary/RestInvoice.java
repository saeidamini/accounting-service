package org.play.wsi.invoice.infrastructure.primary;

import java.util.Collection;
import java.util.UUID;
import org.play.wsi.invoice.domain.Invoice;

public class RestInvoice {

  private final UUID id;
  private final Collection<RestLine> lines;
  private final RestFee total;

  private RestInvoice(UUID id, Collection<RestLine> lines, RestFee total) {
    this.id = id;
    this.lines = lines;
    this.total = total;
  }

  public static RestInvoice from(Invoice invoice) {
    return new RestInvoice(invoice.id().get(), invoice.lines().stream().map(RestLine::from).toList(), RestFee.from(invoice.total()));
  }

  public RestFee getTotal() {
    return total;
  }

  public UUID getId() {
    return id;
  }

  public Collection<RestLine> getLines() {
    return lines;
  }
}
