package org.play.wsi.invoice.infrastructure.primary;

import java.util.UUID;
import org.play.wsi.invoice.application.InvoicesApplicationService;
import org.play.wsi.invoice.domain.InvoiceId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesResource {

  private final InvoicesApplicationService invoices;

  public InvoicesResource(InvoicesApplicationService invoices) {
    this.invoices = invoices;
  }

  @PostMapping
  ResponseEntity<RestInvoice> create(@RequestBody @Validated RestInvoiceToCreate invoiceToCreate) {
    RestInvoice createdInvoice = RestInvoice.from(invoices.create(invoiceToCreate.toDomain()));
    return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
  }

  @GetMapping("/{invoice-id}")
  ResponseEntity<RestInvoice> get(@PathVariable("invoice-id") UUID uuid) {
    return ResponseEntity.of(invoices.get(new InvoiceId(uuid)).map(RestInvoice::from));
  }
}
