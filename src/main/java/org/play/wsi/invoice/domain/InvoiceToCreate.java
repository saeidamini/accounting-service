package org.play.wsi.invoice.domain;

import java.util.Collection;
import org.play.wsi.error.domain.Assert;

public record InvoiceToCreate(Collection<Line> lines) {
  public InvoiceToCreate {
    Assert.notEmpty("lines", lines);
  }

  public Invoice create() {
    return new Invoice(InvoiceId.newId(), lines);
  }
}
