@smoke
Feature: Login Functionality

@smoke
Scenario: Login with valid credentials
When Login with valid credentials
Then Verify the dashboard logo is displayed


@smoke
Scenario: Login with invalid credentials
When Login with invalid credentials
Then Verify the error message




#
#Scenario: Login with empty username
#Given Go to HRMS login page
#When Login with empty username
#Then Verify the empty username error message
#And quit the browser
#
#Scenario: Login with empty password
#Given Go to HRMS login page
#When Login with empty password
#Then Verify the empty password  error message
#And quit the browser


