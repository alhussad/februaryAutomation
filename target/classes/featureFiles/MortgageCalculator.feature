Feature: Mortgage Calculator test DataTable

  @Mortgage
  Scenario Outline: Calculate Mortgage rate with given values and default values
    Given I am on the Mortgage Calculator website
    When I enter the following
      |field        |value|
      |homeValue    |50000|
      |downPayment  |20000|
      |interestRate |5    |
      |loanTerm     |25   |
      |startMonth   |Sep  |
      |starYear     |2020 |
    And I click on the calculate button
    Then I should get mortgage offer with "<totalMonthlyPayment>", "<downPaymentAmount>", "<downPaymentPercentage>", "<loanPayoffDate>", "<totalInterestPaid>", and "<monthlyTaxPaid>"
    Examples:
    |totalMonthlyPayment|downPaymentAmount|downPaymentPercentage|loanPayoffDate|totalInterestPaid|monthlyTaxPaid|
    |$458.71            |$20,000.00       |40.00%               |Aug, 2045     |$22,613.10       |$200.00       |