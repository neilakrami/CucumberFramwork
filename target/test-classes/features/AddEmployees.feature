
@addEmployee
Feature: Add Employee

Background: 
When Login with valid credentials
Then Navigate to add employee page

Scenario: Add employee without login details but without middle name

And Enter firs and last name
Then Click on save Button 
And Verify the employee is added successfully

Scenario: Add employee with login credentials
And Enter firs and last name
When Login details checkbox
Then Enter login details
Then Click on save Button 
And Verify the employee is added successfully

@parameter
Scenario: Add employee without login details but with middle name
When Enter first name as "Ahmet" middle nameas "Can" and last name "Bicer"
Then Click on save Button 
And Verify that "Ahmet Can Bicer" is added successfully