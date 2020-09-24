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

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter employee "<First Name>", "<Middle Name>" and "<Last Name>"
    Then Click on save Button
    And Verify that "<First Name>", "<Middle Name>" and "<Last Name>" is successfully added

    Examples: 
      | First Name | Middle Name | Last Name |
      | XYZ        | X           | ZYX       |
      | ABC        | A           | CBA       |
      | EFG        | G           | GFE       |
      | KLM        | K           | MLK       |

  @dtWithHeader
  Scenario: Adding multiple employees at one execution
    When add multiple employees and verify they are added
      | First Name | Middle Name | Last Name | Employee ID |
      | XYZ        | X           | ZYX       | jflgjldjf   |
      | ABC        | A           | CBA       | ljlfjlsjg   |
      | EFG        | G           | GFE       | klkfjglkjd  |
      | KLM        | K           | MLK       | k;fkd       |
      
   @excelTask
 Scenario: Addign multiple employees from excel file
 	When Add multiple employees from "AddEmployee" verify they are added successfully
 	
 	
 	
 	
 	
 	
 	
 	
 	