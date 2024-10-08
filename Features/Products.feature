Feature: products features

  Background: 
    Given User navigate to products page

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

  Scenario: Verify add products in cart
    When Hover over first product and click Add to cart and clicks Continue Shopping button
    And Hover over second product and click Add to cart and  clicks View Cart button
    Then Verify both products are added to Cart
    And Verify their prices, quantity and total price
      | product 1 | product 2 |
      | Rs. 500   | Rs. 400   |
      |         1 |         1 |
      | Rs. 500   | Rs. 400   |

  Scenario: Verify product quantity in cart
    When User click View Product for any product on home page
    Then Verify product detail is opened
    When Increase quantity to four and click add to cart button and view cart button
    Then Verify that product is displayed in cart page with exact quantity
