Feature: Register User

  Scenario: Verify New User Registration
    Given The user navigate to login page
    Then Verify New User Signup! is visible
    When User enters name and email address and clicks on sign up button
    Then Verify that ENTER ACCOUNT INFORMATION is visible
    When User fills registration form
    And clicks on create account button
    Then Verify that ACCOUNT CREATED! is visible
    When click on continue button
    Then Verify that Logged in as username is visible
    When Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible
    When click Continue button

  Scenario: Register with existing email
    Given The user navigate to login page
    Then Verify New User Signup! is visible
    When User enters name and existing email address as "aks@gmail.com" and clicks on sign up button
    Then Verify error Email Address already exist! is visible
