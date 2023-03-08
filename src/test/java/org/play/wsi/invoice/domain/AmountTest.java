package org.play.wsi.invoice.domain;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.play.wsi.UnitTest;

@UnitTest
class AmountTest {

  @Test
  void shouldScaleAtTwoDigits() {
    Assertions.assertThat(new Amount(new BigDecimal("12.345"))).isEqualTo(new Amount(new BigDecimal("12.35")));
  }
}
