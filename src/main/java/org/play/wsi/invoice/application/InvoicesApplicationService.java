package org.play.wsi.invoice.application;

import java.util.Optional;
import org.play.wsi.invoice.domain.*;
import org.springframework.stereotype.Service;

@Service
public class InvoicesApplicationService {

  private final InvoiceCreator invoiceCreator;
  private InvoicesRepository invoices;

  public InvoicesApplicationService(InvoicesRepository invoices) {
    invoiceCreator = new InvoiceCreator(invoices);
    this.invoices = invoices;
  }

  public Invoice create(InvoiceToCreate invoiceToCreate) {
    return invoiceCreator.create(invoiceToCreate);
  }

  public Optional<Invoice> get(InvoiceId invoice) {
    return invoices.get(invoice);
  }
}
