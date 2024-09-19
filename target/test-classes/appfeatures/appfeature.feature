Feature: Home Page Functionality

Scenario: Verfiy the title of page
Given User is at amazon portal 
Then Title should contains the "Shopping" 

Scenario: Verfiy the cart icon
Given User is at amazon portal 
Then User should be able to see cart icon

Scenario: Verify the sign in page
Given User is at amazon portal
When user should click in Sign in button 
And User should enter the username as "9765434652"
And User should click on continue button of amazon 
And User should enter the password as "9765434652"

