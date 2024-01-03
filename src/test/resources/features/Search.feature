@All
Feature: Search 

    @search @positive
    Scenario: Search with result
    Given User success login
    Then User input valid value
    And User click button search
    Then User redirect to result page

    @search @negative
    Scenario: Search no result
    Given User success login
    Then User input invalid value
    And User click button search
    Then User get alert no results