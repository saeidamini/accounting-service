package org.play.wsi.invoice.domain;

import java.util.UUID;
import org.play.wsi.error.domain.Assert;

public record InvoiceId(UUID id) {
  public InvoiceId {
    Assert.notNull("id", id);
  }

  public static InvoiceId newId() {
    return new InvoiceId(UUID.randomUUID());
  }

  public UUID get() {
    return id();
  }
}
