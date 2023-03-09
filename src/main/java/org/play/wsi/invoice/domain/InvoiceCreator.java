package org.play.wsi.invoice.domain;

import org.play.wsi.error.domain.Assert;

public class InvoiceCreator {

  private final InvoicesRepository invoices;

  public InvoiceCreator(InvoicesRepository invoices) {
    this.invoices = invoices;
  }

  public Invoice create(InvoiceToCreate invoiceToCreate) {
    Assert.notNull("invoiceToCreate", invoiceToCreate);
    Invoice invoice = invoiceToCreate.create();
    invoices.save(invoice);
    return invoice;
  }
}
