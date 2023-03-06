package org.play.wei.error.domain;

import static org.assertj.core.api.Assertions.*;

import org.play.wei.UnitTest;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@UnitTest
class NotAfterTimeExceptionTest {

  private static final String FIELD = "myField";

  @Test
  void shouldGetNotAfterExceptionInformation() {
    NotAfterTimeException exception = NotAfterTimeException.notAfter(FIELD, Instant.ofEpochSecond(1337));

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("Time in \"myField\" must be after 1970-01-01T00:22:17Z but wasn't");
  }

  @Test
  void shouldGetNotStriclyAfterExceptionInformation() {
    NotAfterTimeException exception = NotAfterTimeException.notStrictlyAfter(FIELD, Instant.ofEpochSecond(1337));

    assertDefaultInformation(exception);
    assertThat(exception.getMessage()).isEqualTo("Time in \"myField\" must be strictly after 1970-01-01T00:22:17Z but wasn't");
  }

  private void assertDefaultInformation(NotAfterTimeException exception) {
    assertThat(exception.type()).isEqualTo(AssertionErrorType.NOT_AFTER_TIME);
    assertThat(exception.field()).isEqualTo(FIELD);
    assertThat(exception.parameters()).isEmpty();
  }
}
