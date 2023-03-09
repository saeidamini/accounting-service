package org.play.wsi.invoice.infrastructure.primary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.play.wsi.JsonHelper;
import org.play.wsi.UnitTest;
import org.play.wsi.invoice.domain.InvoicesFixture;

@UnitTest
class RestInvoiceTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestInvoice.from(InvoicesFixture.invoice()))).isEqualTo(json());
  }

  private String json() {
    return """
      {\
      "id":"439cd126-8ddc-410c-b39e-542bded80b64",\
      "lines":[\
      {"quantity":2,"unitPrice":{"amount":500.00,"currency":"EURO"}},\
      {"quantity":1,"unitPrice":{"amount":400.00,"currency":"EURO"}}\
      ],\
      "total":{"amount":1400.00,"currency":"EURO"}\
      }\
      """;
  }
  /*
  isEqualTo("""
        {
        "id": "id",
        "totalAmount": "100"
        }
        """)));
  toJson(RestInvoice.builder()
      .id("id")
      .totalAmount("100")
      .build()))
      .isEqualTo("""
        {
        "id": "id",
        "totalAmount": "100"
        }
        """); */
}
