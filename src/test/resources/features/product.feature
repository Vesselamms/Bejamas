Feature: Product
  Background:
    Given the user is on the main page

  Scenario:Verify product

    When the user should see  have a flag product
    Then the user verify that this picture "Photo of the day"


  Scenario: Verify the sorting

    When the user able to  click sorting module
    Then the user verify that high-low price product

  Scenario: Verify the Product List

    When user should see six different artworks under the category
    And  user able to select which artworks category do you want
    And  user move to mouse mark on the image,the "ADD TO CART" bar is displayed.
    Then user should able to see product which has "Best Seller" flag