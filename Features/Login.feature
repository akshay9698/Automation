Feature: Log in

  Scenario: Log in with valid credentials
    Given The user navigate to login page
    When user enter email as "aks@gmail.com" and password as "@Kshay12"
    And user clicks on log in
    Then logged in username should be displayed and click on logout
