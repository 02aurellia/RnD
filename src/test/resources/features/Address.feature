@All
Feature: View Address Page, Create New Address, Edit Address and Delete Address

    @address @view
    Scenario: User view Address Page
    Given User success login and go to homepage
    And User go to My Account page
    Then User go to Address Book page

    @address @create @positive
    Scenario: User Successfully Create New Address
    Given User in My Account page
    Then User go to Address Book page
    And User click button Add New Address
    And User input valid contact information
    And User input valid address
    And User click button Save new address
    Then User get alert You save the address

    @address @create @negative
    Scenario: User failed Create New Address - Empty Field
    Given User in My Account page
    Then User go to Address Book page
    And User click button Add New Address
    And User click button Save new address
    Then User get alert required field address

    @address @edit @positive
    Scenario: User success edit address
    Given User in My Account page
    Then User go to Address Book page
    Then User click button update address
    And User input new contact information
    And User input new address
    And User click button Save edited address
    Then User get alert You save the address

    @address @edit @negative
    Scenario: User failed edit address - empty required field
    Given User in My Account page
    Then User go to Address Book page
    Then User click button update address
    Then User clear required field address
    And User click button Save edited address
    Then User get alert required field address

    @address @delete
    Scenario: User successfully delete address
    Given User in My Account page
    Then User go to Address Book page
    And User click button delete address 
    Then User get confirmation modal delete
    And User click button OK delete address
    Then User get alert You deleted the address

    @address @delete 
    Scenario: User cancel delete address
    Given User in My Account page
    Then User go to Address Book page
    And User click button delete address 
    Then User get confirmation modal delete
    And User click button Cancel delete address




