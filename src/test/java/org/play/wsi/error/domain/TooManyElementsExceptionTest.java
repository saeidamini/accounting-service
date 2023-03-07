package org.play.wsi.error.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import org.junit.jupiter.api.Test;
import org.play.wsi.UnitTest;

@UnitTest
class TooManyElementsExceptionTest {

  @Test
  void shouldGetExceptionInformation() {
    TooManyElementsException exception = TooManyElementsException.builder().field("myField").maxSize(1).size(10).build();

    assertThat(exception.type()).isEqualTo(AssertionErrorType.TOO_MANY_ELEMENTS);
    assertThat(exception.field()).isEqualTo("myField");
    assertThat(exception.parameters()).containsOnly(entry("maxSize", "1"), entry("currentSize", "10"));
    assertThat(exception.getMessage()).isEqualTo("Size of collection \"myField\" must be at most 1 but was 10");
  }
}
