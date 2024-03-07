@All
Feature: Add to Cart, View Detail Cart, Edit Cart and Delete Cart

    @add @positive @cart
    Scenario: User successfully add product to cart
    Given User in homepage
    Then User go to selected menu page
    Then User go to selected category
    Then User choose product and option
    And User click button add to Cart
    Then User get alert success add to Cart

    @add @negative @cart
    Scenario: User failed add product to cart - Didn't choose option
    Given User in homepage
    Then User go to selected menu page
    Then User go to selected category
    Then User choose product
    And User click button add to Cart
    Then User get alert You need to choose options for your item

    @view @cart
    Scenario: User view detail cart
    Given User in homepage
    Then User click button Cart
    And User click button View and Edit Cart
    Then User redirect to Cart Page

    @edit @cart @positive
    Scenario: User success edit cart
    Given User in homepage
    Then User click button Cart
    And User click button Edit product
    Then User choose new option
    And User click button Update Cart
    Then User get alert success updated shopping cart

    @edit @cart @negative
    Scenario: User failed edit cart - Didn't choose option
    Given User in homepage
    Then User click button Cart
    And User click button Edit product
    Then User click button Update Cart
    Then User get alert options required field

    @delete @cart @negative
    Scenario: User cancel delete product from cart
    Given User in homepage
    Then User click button Cart
    And User click button delete product
    Then User get confirmation modal
    And User click button Cancel

    @delete @cart @positive
    Scenario: User success delete product from cart
    Given User in homepage
    Then User click button Cart
    And User click button delete product
    Then User get confirmation modal
    And User click button Ok


