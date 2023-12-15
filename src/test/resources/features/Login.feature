@All
Feature: Login 

    @login @positive
    Scenario: User successfully login
        Given User on a homepage
        Then User go to a Sign In Page
        And User input valid credentials
        And User click button Sign In
        Then User redirect to homepage

    @login @negative @invalidcredentials
    Scenario: User failed login - invalid credentials
        Given User on a homepage
        Then User go to a Sign In Page
        And User input invalid credentials
        And User click button Sign In
        Then User get alert the account incorrect

    @login @negative @empty
    Scenario: User failed login - empty credentials
        Given User on a homepage
        Then User go to a Sign In Page
        And User click button Sign In
        Then User get alert required field
    