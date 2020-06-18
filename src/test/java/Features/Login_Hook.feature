Feature: Verify login functionality of Myntra

@Smoke
Scenario: Verify login page is displayed
Given user is on landing page
When user click on profile
And user click on login link
Then user is on login page

@Sanity
Scenario: Verify user is able to enter mobile number in login page
Given user is on landing page
When user click on profile
And user click on login link
And user is on login page
And user enters mob no "1234567"

@Regression @Sanity
Scenario: Verify error message for invalid mobile number is displayed
Given user is on landing page
When user click on profile
And user click on login link
And user is on login page
And user enters mob no "1234567"
Then error message for invalid mobile no is displayed