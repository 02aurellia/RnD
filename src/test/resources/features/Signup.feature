@All
  Feature: Sign Up

    @signup @positive
    Scenario: User successfully signup
        Given User on homepage
        And User go to Create an Account page
        When User input Personal Information
        And User input Sign In Information
        And User click button Create an Account
        Then User is navigated to Account page

    @signup @negative @mismatchpass
    Scenario: User failed signup - mismatch password
        Given User on homepage
        And User go to Create an Account page
        When User input Personal Information
        And User input Sign In Information with mismatch password
        And User click button Create an Account
        Then Username get password mismatch alert
    
    @signup @negative @weakpass
    Scenario: User failed signup - weak password
        Given User on homepage
        And User go to Create an Account page
        When User input Personal Information
        And User input Sign In Information with weak password
        And User click button Create an Account
        Then Username get password weak alert

    @signup @negative @empty
    Scenario: User failed signup - empty credentials
        Given User on homepage
        And User go to Create an Account page
        And User click button Create an Account
        Then User get required field alert
