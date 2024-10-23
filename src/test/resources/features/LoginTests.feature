Feature: Login feature

  Scenario: Login Success
    //Given I open browser
    Given I open Login Page
    When I enter email "elena.churinova@testpro.io"
    And I enter password "skL&mpg67"
    And I submit
    Then I am logged in

  Scenario: Login incorrect password
    Given I open Login Page
    When I enter email "elena.churinova@testpro.io"
    And I enter incorrect password "skL12&mpg67"
    And I submit
    Then I am not logged in

  Scenario: Login Not existing email
    Given I open Login Page
    When I enter not existing email "el33.churinova@testpro.io"
    And I enter password "skL&mpg67"
    And I submit
    Then I am not logged in

  Scenario: Empty login and password
    Given I open Login Page
    When I don't enter email ""
    And I don't enter password ""
    And I submit
    Then I am not logged in