package org.play.wsi.invoice.infrastructure.primary;

import static org.play.wsi.cucumber.CucumberAssertions.assertThatLastResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.play.wsi.cucumber.CucumberRestTemplate;
import org.play.wsi.cucumber.CucumberTestContext;
import org.springframework.beans.factory.annotation.Autowired;

//@Component // For error in Autowired.
public class InvoicesSteps {

  @Autowired
  public CucumberRestTemplate rest;

  @Given("I create invoice")
  public void create_invoice(List<Map<String, String>> lines) {
    String payLoad = "{\"lines\":[" + linesPayload(lines) + "]}";
    rest.post("/api/invoices/", payLoad);
  }

  private String linesPayload(List<Map<String, String>> lines) {
    return lines
      .stream()
      .map(line ->
        "{\"quantity\":\"" + line.get("Quantity") + "\",\"unitPrice\": {\"amount\":\"" + line.get("UnitPrice") + "\",\"currency\":\"EURO\"}"
      )
      .collect(Collectors.joining(","));
  }

  @When("I get the created invoice")
  public void get_the_created_invoice() {
    rest.get("/api/invoices/" + CucumberTestContext.getElement("$.id"));
  }

  @Then("I should have invoice")
  public void should_have_invoice(Map<String, String> invoice) {
    assertThatLastResponse().hasOkStatus().hasResponse().containing(invoice);
  }
}
