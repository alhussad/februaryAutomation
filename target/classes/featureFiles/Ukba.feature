Feature: UKBA Test Automation

  Background:
    Given I am on UKBA website "https://www.gov.uk/check-uk-visa/y"

  @TestToRun1
  Scenario: 1_Country and Study
    Given I provide the nationality of "Japan"
    When I click on Continue button
    And I select the reason as study
    And I click on Continue button
    And I state that I intend stay for more than 6 months
    And I click on Continue button
    Then I should be informed that "You’ll need a visa to study in the UK"

  @TestToRun1
  Scenario: 2_CountryA and Tourism
    Given I provide the nationality of "Japan"
    When I click on Continue button
    And I select the reason as Tourism
    And I click on Continue button
    Then I should be informed that "You will not need a visa to come to the UK"

  @TestToRun1
  Scenario: 3_CountryB and Tourism
    Given I provide the nationality of "Russia"
    When I click on Continue button
    And I select the reason as Tourism
    And I click on Continue button
    And I state I am not travelling or visiting a partner or family
    And I click on Continue button
    Then I should be informed that "You’ll need a visa to come to the UK"

  @TestToRun1
  Scenario Outline: 4_Country and Study with Examples
    Given I provide the nationality of "<countryName>"
    When I click on Continue button
    And I select the reason as study
    And I click on Continue button
    And I state that I intend stay for more than 6 months
    And I click on Continue button
    Then I should be informed that "You’ll need a visa to study in the UK"
    Examples:
      | countryName |
      | Japan       |
      | Australia   |
      | Canada      |
      | USA         |

  @TestToRun
  Scenario Outline: 5_Country and Tourism with Examples Scenario Outline
    Given I provide the nationality of "<countryName>"
    When I click on Continue button
    And I select the reason as Tourism
    And I click on Continue button
    Then I should be informed that "You will not need a visa to come to the UK"
    Examples:
      | countryName |
      | Japan       |
#      | Australia   |
#      | Canada      |
#      | USA         |
#      | Malaysia    |

  @TestToRun1
  Scenario Outline: 6_CountryB and Tourism with Examples
    Given I provide the nationality of "<countryName>"
    When I click on Continue button
    And I select the reason as Tourism
    And I click on Continue button
    And I state I am not travelling or visiting a partner or family
    And I click on Continue button
    Then I should be informed that "You’ll need a visa to come to the UK"
    Examples:
      | countryName |
      | Russia      |
      | Cuba        |
      | Belarus     |
      | Albania     |
      | Hong Kong   |
      | South Korea |