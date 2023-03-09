package org.play.wsi.invoice.domain;

import java.util.Optional;

public interface InvoicesRepository {
  void save(Invoice invoice);

  Optional<Invoice> get(InvoiceId invoice);
}
