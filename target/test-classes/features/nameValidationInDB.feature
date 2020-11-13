Feature: Name validation against DB
@dbBalidation
Scenario: First name validation against DB - searching by Employee ID
When 	Login with valid credentials
Then 	Verify the dashboard logo is displayed
When 	Navigate to employee list
And 	Enter a vlid Employee ID "0056266"
Then 	Click on search Button
And 	Verify the table is dislayed
When  Get first name from the table
Then  Get first name from the DB
Then Validate first names from ui against DB
