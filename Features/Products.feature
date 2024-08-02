Feature: products features

  Background: User navigate to products page

  Scenario: Verify all products and products details page
    Then Verify user is navigated to ALL PRODUCTS page successfully
    And Product list should be visible to user
    When User clicks on the view product of the first product
    Then User should be landed on the product details page
    And User should see the product details are visible
      | Value                  |
      | Category: Women > Tops |
      | Availability: In Stock |
      | Condition: New         |
      | Brand: Polo            |

  Scenario: Verify search product functionality
    Then User  Enter product name as 'Tshirt' in search input and click search button
    And Verify SEARCHED PRODUCTS is visible
    And Verify all the products related to search are visible

  #Scenario: Verify add products in cart
    #When Hover over first product and click Add to cart and clicks Continue Shopping button
    #And Hover over second product and click Add to cart and  clicks View Cart button
    #Then Verify both products are added to Cart
    #And Verify their prices, quantity and total price
