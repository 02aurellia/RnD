@searchwithbg
Feature: Search with Background

    Background: User success login
    Given User on homepage
    Then User go to Sign In Page
    And User input credentials
    And User click button

    Scenario: Search with result
    Then User input valid value
    And User click button search
    Then User redirect to result page

    Scenario: Search no result
    Then User input invalid value
    And User click button search
    Then User get alert no results