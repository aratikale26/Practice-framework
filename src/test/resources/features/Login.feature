Feature: OrangeHRM Login Functionality

Scenario Outline: Login with valid and invalid credentials

Given user is on login page
When User enters valid credentials "<username"> and "<password">
And Clicks on login button
Then User waits for the dashboard to be visible
Then User should see "<result>"

Examples:
| username | password | result |
| Admin    | admin123 | Dashboard |
| Admin    | wrgpass1 | Invalid credentials |
| wrgusr   | admin123 | Invalid credentials |




