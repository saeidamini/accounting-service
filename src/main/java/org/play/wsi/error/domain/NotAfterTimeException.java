package org.play.wsi.error.domain;

import java.time.Instant;

public class NotAfterTimeException extends AssertionException {

  private NotAfterTimeException(String field, String message) {
    super(field, message);
  }

  public static NotAfterTimeException notStrictlyAfter(String fieldName, Instant other) {
    return new NotAfterTimeException(fieldName, message(fieldName, "must be strictly after", other));
  }

  public static NotAfterTimeException notAfter(String fieldName, Instant other) {
    return new NotAfterTimeException(fieldName, message(fieldName, "must be after", other));
  }

  private static String message(String fieldName, String hint, Instant other) {
    return new StringBuilder()
      .append("Time in \"")
      .append(fieldName)
      .append("\" ")
      .append(hint)
      .append(" ")
      .append(other)
      .append(" but wasn't")
      .toString();
  }

  @Override
  public AssertionErrorType type() {
    return AssertionErrorType.NOT_AFTER_TIME;
  }
}
