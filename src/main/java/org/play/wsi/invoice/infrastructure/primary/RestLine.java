package org.play.wsi.invoice.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.play.wsi.invoice.Quantity;
import org.play.wsi.invoice.domain.Line;

public class RestLine {

  private final int quantity;
  private final RestFee unitPrice;

  public RestLine(@JsonProperty("quantity") int quantity, @JsonProperty("unitPrice") RestFee unitPrice) {
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public static RestLine from(Line line) {
    return new RestLine(line.quantity().get(), RestFee.from(line.unitPrice()));
  }

  public int getQuantity() {
    return quantity;
  }

  public RestFee getUnitPrice() {
    return unitPrice;
  }

  public Line toDomain() {
    return new Line(new Quantity(quantity), unitPrice.toDomain());
  }
}
