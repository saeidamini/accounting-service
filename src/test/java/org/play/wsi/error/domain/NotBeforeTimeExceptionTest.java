package org.play.wsi.error.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.play.wsi.UnitTest;

@UnitTest
class NotBeforeTimeExceptionTest {

  private static final String FIELD = "myField";

  @Test
  void shouldGetNotBeforeExceptionInformation() {
    NotBeforeTimeException exception = NotBeforeTimeException.notBefore(FIELD, Instant.ofEpochSecond(1337));

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("Time in \"myField\" must be before 1970-01-01T00:22:17Z but wasn't");
  }

  @Test
  void shouldGetNotStriclyAfterExceptionInformation() {
    NotBeforeTimeException exception = NotBeforeTimeException.notStrictlyBefore(FIELD, Instant.ofEpochSecond(1337));

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("Time in \"myField\" must be strictly before 1970-01-01T00:22:17Z but wasn't");
  }

  private void assertDefaultInformation(NotBeforeTimeException exception) {
    assertThat(exception.type()).isEqualTo(AssertionErrorType.NOT_BEFORE_TIME);
    assertThat(exception.field()).isEqualTo(FIELD);
    assertThat(exception.parameters()).isEmpty();
  }
}
