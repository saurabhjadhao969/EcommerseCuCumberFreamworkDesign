Feature: Search Functionality

Scenario: User searches for a valid product 
Given User open the Application
When User enters valid product "HP" into search field
And User clicks on search button
Then User should get valid product displayed in Search results

Scenario: User searches for an invalid product
Given User opens the application
When User enters invalid product "Honda" into search field
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any products
Given User opens the application
When User dont enter any product name into search box field
And User clicks on search button
Then User should get a message about no product matching

