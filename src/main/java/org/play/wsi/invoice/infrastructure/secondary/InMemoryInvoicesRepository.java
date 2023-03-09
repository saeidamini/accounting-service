package org.play.wsi.invoice.infrastructure.secondary;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.play.wsi.error.domain.Assert;
import org.play.wsi.invoice.domain.Invoice;
import org.play.wsi.invoice.domain.InvoiceId;
import org.play.wsi.invoice.domain.InvoicesRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryInvoicesRepository implements InvoicesRepository {

  private final Map<InvoiceId, Invoice> invoices = new ConcurrentHashMap<>();

  @Override
  public void save(Invoice invoice) {
    Assert.notNull("invoice", invoice);
    invoices.put(invoice.id(), invoice);
  }

  @Override
  public Optional<Invoice> get(InvoiceId invoice) {
    return Optional.ofNullable(invoices.get(invoice));
  }
}
