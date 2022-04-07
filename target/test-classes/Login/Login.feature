#This is what a BA does
Feature: OrangeHRM

#Background:
#Given I should be in the Login page of OrangeHRM

Scenario: Login Validation
Given I should be in the Login page of OrangeHRM
When Enter Name
And Enter Password
And Click on LoginButton
And Login Successfull
And Logout
Then Logout Successfull