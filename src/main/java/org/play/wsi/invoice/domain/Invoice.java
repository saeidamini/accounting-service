package org.play.wsi.invoice.domain;

import java.util.Collection;
import org.play.wsi.error.domain.Assert;

public record Invoice(InvoiceId id, Collection<Line> lines) {
  public Invoice {
    Assert.notEmpty("lines", lines);
    Assert.notNull("id", id);
  }

  public Fee total() {
    return lines.stream().map(Line::total).reduce(Fee.ZERO, Fee::add);
  }
}
