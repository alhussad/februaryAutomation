Feature: BlazeDemo purchase flights

  @Blaze
  Scenario Outline: Choosing departure and destination cities and finding flights
    Given I am on the Welcome to Simple Travel Agency landing page
    When I choose from the "<departureCity>" and "<destinationCity>" from the drop down
    And I click on the find flight button
    Then I should be able to see "<departureCity>" and "<destinationCity>" on the BlazeDemo reserve page
    Examples:
    |departureCity|destinationCity|
    |Boston       |Rome           |

#  @Blaze
  Scenario Outline: Task -- Purchase Flights
    Given I am on the Welcome to Simple Travel Agency landing page
    When I choose from the "<departureCity>" and "<destinationCity>" from the drop down
    And I click on the find flight button
    And I choose the first flight from the reserve page
    And I click Purchase Flight button on the Purchase page
    Then "Thank you for your purchase today!" message is displayed on the confirmation page
    Examples:
      |departureCity|destinationCity|
      |Portland     |London         |