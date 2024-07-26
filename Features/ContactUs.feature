Feature: Contact us form
  Scenario: Verify contact us functionality
    Given User navigate to contact us page
    Then verify the GET IN TOUCH text
    When User Enter name, email, subject and message
    And Upload file and clicks submit
    Then Verify success message Success! Your details have been submitted successfully. is visible
    When User Click Home button
    Then verify that landed to home page successfully