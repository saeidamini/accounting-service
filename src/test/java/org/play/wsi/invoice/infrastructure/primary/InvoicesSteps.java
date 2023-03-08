package org.play.wsi.invoice.infrastructure.primary;

import static org.play.wsi.cucumber.CucumberAssertions.assertThatLastResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.play.wsi.cucumber.CucumberRestTemplate;
import org.play.wsi.cucumber.CucumberTestContext;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoicesSteps {

  @Autowired
  public CucumberRestTemplate rest;

  @Given("I create invoice")
  public void create_invoice(List<Map<String, String>> lines) {
    rest.post("/api/invoices/", lines.stream().map(line -> "{"));
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
