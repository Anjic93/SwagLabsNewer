Feature: Web Login

  Background:
    Given user is on login page

  Scenario: Verify that user can log in successfully with valid credentials
    When user enters valid username
    And user enters valid password
    And user click login button
    Then user should be logged in successfully

  @important
  Scenario: Verify that user can't login with invalid username and valid password
    When user enters invalid username
    And user enters valid password
    And user click login button
    Then error message for invalid username is displayed

  Scenario: Verify that user can't login with valid username and invalid password
    When user enters valid username
    And user enters invalid password
    And user click login button
    Then error message for invalid password is displayed

  Scenario: Verify that user can't login with invalid username and invalid password
    When user enters invalid username
    And user enters invalid password
    And user click login button
    Then error message for invalid username and password is displayed









