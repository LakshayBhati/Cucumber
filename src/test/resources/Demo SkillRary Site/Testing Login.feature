Feature: Test the SkillRary App
1) Valid Case
2) Invalid Case


#If my Pre-requisite (Given) is common I can write Background
Background:
Given I should open the browser and navigate to the Skillrary app 

#Scenario: To test the login with user credentials
#When Enter Username "user"
#And Enter Password "user"
#And Click on the LoginButton
#Then I should see the username as "Harry Den"
#
#Scenario: To test the login with Admin credentials
#When Enter Username "admin"
#And Enter Password "admin"
#And Click on the LoginButton
#Then I should see the admin as "SkillRary Admin"

#When I want to use multiple positive of negative cases
#I use scenario outline

@PositiveTesting
Scenario Outline: To test login with multiple positive data
When Enter Username "<user>"
And Enter Password "<pwd>"
And Click on the LoginButton
Then I should see the username as "<username>"

Examples:
|user|pwd|username|
|user|user|Harry Den|
|user|user|Harry Den|
|admin|admin|SkillRary Admin|

#@ Stands for Tag
#For running specific cases I give Tags
@NegativeTesting
Scenario: To test the login with Invalid credentials
When Enter Username "Lakshay"
And Enter Password "admin"
And Click on the LoginButton
Then I should navigate the "Register"