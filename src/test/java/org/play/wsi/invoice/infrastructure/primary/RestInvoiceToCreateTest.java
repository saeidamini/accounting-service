package org.play.wsi.invoice.infrastructure.primary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.play.wsi.JsonHelper;
import org.play.wsi.UnitTest;
import org.play.wsi.invoice.domain.InvoicesFixture;

@UnitTest
class RestInvoiceToCreateTest {

  @Test
  void shouldConvertToDomain() {
    assertThat(JsonHelper.readFromJson(json(), RestInvoiceToCreate.class).toDomain())
      .usingRecursiveComparison()
      .isEqualTo(InvoicesFixture.invoiceToCreate());
  }

  private String json() {
    return """
      {
      "lines": [
          {
            "quantity": 2,
            "unitPrice": {
              "amount": 500.00,
              "currency": "EURO"
            }
          },
          {
            "quantity": 1,
            "unitPrice": {
              "amount": 450.00,
              "currency": "EURO"
            }
          }
        ]
      }
      """;
  }
  // bean validation
  //  @Test
  //  void shouldThrowExceptionWhenInvalid(){
  //    assertThatThrownBy(() -> JsonHelper.readFromJson(json(), RestInvoiceToCreate.class))
  //      .isInstanceOf(ConstraintViolationException.class);
  //  }
}
