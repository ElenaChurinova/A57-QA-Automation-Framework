Feature: Login feature

  Scenario: Login Success
    //Given I open browser
    Given I open Login Page
    When I enter email "elena.churinova@testpro.io"
    And I enter password "skL&mpg67"
    And I submit
    Then I am logged in