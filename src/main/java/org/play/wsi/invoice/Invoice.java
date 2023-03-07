package org.play.wsi.invoice;

import java.util.Collection;
import org.play.wsi.error.domain.Assert;

public record Invoice(Collection<Line> lines) {
  public Invoice {
    Assert.notEmpty("lines", lines);
  }

  public Fee total() {
    return lines.stream().map(Line::total).reduce(Fee.ZERO, Fee::add);
  }
}
