@PersonalInfo
Feature: Update Personal Information

Background:
Given A global driver is used for entire test

Scenario: TC_002_Update_First_Name_In_MyAccount_Section
Given User is on the home page
When User enters the UserName and password and clicks on the SignIn button
Then User is able to login to the shopping site Successfully
When User clicks on the My Personal Information link
And User updates the FirstName
And User enters his password and clicks on Save
Then User gets a confirmation and the FirstName is updated successfully