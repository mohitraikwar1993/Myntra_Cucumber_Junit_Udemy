Feature: Verify login functionality of Myntra

Background:
Given validate the browser
When browser is triggered
Then check if browser is started


Scenario: Verify login page is displayed
Given user is on landing page
When user click on profile
And user click on login link
Then user is on login page

  
