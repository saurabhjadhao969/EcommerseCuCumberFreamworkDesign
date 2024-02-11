Feature: Registration functionality

Scenario: User creates an account only mandatory fields
Given User navigates to Register account page
When User enters the below fields
|firstName	|Saurabh                   |
|LastName		|jadhav                    |
|telephone	|25648962222							 |
|password		|123456       							 |
And User selects Privacy policies
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account with all  fields
Given User navigates to Register account page
When User enters the below fields
|firstName	|Saurabh                   |
|LastName		|jadhav                    |
|telephone	|25648962222							 |
|password		|123456        						 |
And User selects Yes for Newsletter
And User selects Privacy policies
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register account page
When User enters the details into below fields for duplicate account
|firstName	|Saurabh                    |
|LastName		|jadhav                     |
|email  		|saurabhjadhao201@gmail.com |
|telephone	|25648962222							  |
|password		|123456        							|
And User selects Yes for Newsletter
And User selects Privacy policies
And User clicks on continue button
Then User account should get a proper warning messages about duplicate email

Scenario: User create an account without filling any details
Given User navigates to Register account page
When User dont enter any details into fields
And User clicks on continue button
Then User account should get a proper warning messages for every mandatory fields


