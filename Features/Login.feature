Feature: Log in

  @sanity @regression
  Scenario: Log in with valid credentials
    Given The user navigate to login page
    When user enter email as "aks@gmail.com" and password as "@Kshay12"
    And user clicks on log in
    Then logged in username should be displayed and click on logout

  Scenario Outline: Login Data Driven with Excel
    Given The user navigate to login page
    Then logged in username should be displayed by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
