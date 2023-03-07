package org.play.wsi.invoice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.play.wsi.error.domain.MissingMandatoryValueException;

public class InvoiceTest {

  @Test
  void shouldNotBuildWithoutLines() {
    assertThatThrownBy(() -> new Invoice(null)).isExactlyInstanceOf(MissingMandatoryValueException.class).hasMessageContaining("lines");
  }

  @Test
  void shouldNotBuildZeroLines() {
    assertThatThrownBy(() -> new Invoice(List.of()))
      .isExactlyInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("lines");
  }

  @Test
  void shouldGetInvoiceInformation() {
    Invoice invoice = InvoicesFixture.invoice();
    assertThat(invoice.lines()).containsExactly(InvoicesFixture.getInvoiceLine(2, 500), InvoicesFixture.getInvoiceLine(1, 400));
    assertThat(invoice.total()).isEqualTo(InvoicesFixture.getFee(1400));
  }
}
