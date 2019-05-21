@PlaceOrder
Feature: Place Order

Background:
Given A global driver is used for entire test

Scenario: TC_001_Order_TShirt_And_Verify_Order_History
Given User is on the home page
When User enters the UserName and password and clicks on the SignIn button
Then User is able to login to the shopping site Successfully
When User navigates to the TShirts page
And User Adds the TShirt to his cart
And User confirms the checkout
And Proceeds with the checkout process with confirmation of the shipping and payment details
Then User should be able to verify the order in order history table