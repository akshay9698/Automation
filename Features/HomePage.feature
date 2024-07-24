Feature: Log in

  Scenario: Log in with valid creadentials
    Given The user navigate to log in page
    When user enter email as "aks@gmail.com" and password as "@Kshay12"
    And user clicks on log in
    Then logged in username should be displayed.
