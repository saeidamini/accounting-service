Feature: Invoice
  Scenario: Create and get invoice
    Given I create invoice
      | Quantity | Unit price |
      | 1        | 150.00     |
      | 4        | 500.00     |
    When I get the created invoice
    Then I should have invoice
      | Total  | 2150.00 |


