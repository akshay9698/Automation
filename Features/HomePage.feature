Feature: Home page features

  Scenario: Verify subscription in home page
    Given user is on Homepage
    When Scroll down to footer
    And Enter email address in input
    Then Verify text SUBSCRIPTION and click arrow button
    And Verify success message You have been successfully subscribed! is visible
