package org.play.wsi.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import org.play.wsi.invoice.domain.InvoiceToCreate;

public class RestInvoiceToCreate {

  private final Collection<RestLine> lines;

  public RestInvoiceToCreate(@JsonProperty("lines") Collection<RestLine> lines) {
    this.lines = lines;
  }

  public InvoiceToCreate toDomain() {
    return new InvoiceToCreate(lines.stream().map(RestLine::toDomain).toList());
  }
}
