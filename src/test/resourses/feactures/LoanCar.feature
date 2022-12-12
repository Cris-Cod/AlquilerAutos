Feature: Fly and Rental

  Scenario: Rental a Car
    Given I enter a Miles car rental page
    When I enter  a place when pick up the car
    And I select the start day
    And serch the car
    And I select the second car
    And I enter a full name
    And I enter a phone number
    And I enter a email
    And I made click in next button
    Then Validate the method pay

