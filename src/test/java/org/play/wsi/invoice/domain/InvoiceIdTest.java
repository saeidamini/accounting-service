package org.play.wsi.invoice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.play.wsi.UnitTest;

@UnitTest
class InvoiceIdTest {

  @Test
  void shouldGenerateNewId() {
    assertThat(InvoiceId.newId()).isNotNull().isNotEqualTo(InvoiceId.newId());
  }
}
