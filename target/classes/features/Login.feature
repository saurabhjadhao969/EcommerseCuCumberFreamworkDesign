Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigates to login page
When User has entered valid email address <username> into the email field
And User has entered valid password <password> into password field
And User clicks on Login button
Then User should get successsfully logged in

Examples:
|username               |password|
|amotooricap1@gmail.com |12345   |
|amotooricap2@gmail.com |12345   |
|amotooricap3@gmail.com |12345   |



Scenario: Login with invalid credential
Given User has navigates to login page 
When User enters invalid email address "" into email field 
And User enters invalid password "" into password field
And User clicks on Login button
Then user should get a proper warning message 

Scenario: Login with valid email and invalid password
Given User has navigates to login page 
When User has entered valid email address "" into the email field
And User enters invalid password "" into password field 
And User clicks on Login button
Then user should get a warning message 

Scenario: Login with invalid email and valid password
Given User has navigates to login page 
When User enters invalid email address "" into email field 
And User has entered valid password "" into password field
And User clicks on Login button
Then user should get a warning message 

Scenario: Login without providing any credential
Given User has navigates to login page 
When user dont enter any email address  into email field 
And  user dont enter any password into  password field 
And User clicks on Login button
Then user should get a warning message 
