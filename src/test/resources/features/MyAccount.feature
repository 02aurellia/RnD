@All
Feature: My Account Page

    @edit @contact @name
    Scenario: User edit contact information - change name
    Given User successfully login
    Then User go to my account page
    Then User click button edit contact
    Then User input new name
    And User click button Save contact
    Then User get alert You saved the account information

    @edit @address @positive
    Scenario: User successfully edit address
    Given User successfully login
    Then User go to my account page
    Then User click button edit address
    Then User input contact information
    Then User input address
    And User click button Save address
    Then User get alert You saved the address

    @edit @address @negative
    Scenario: User failed edit address - empty required field
    Given User successfully login
    Then User go to my account page
    Then User click button edit address
    Then User clear required field
    And User click button Save address
    Then User get alert address required field