#Author: Instructor
#@APIworkflow
Feature: Syntax HRMS API Workflow
  Description: This feature file tests Syntax HRMS API WorkFlow

  Background: 
    Given a JWT is generated

 # @APIworkflow
  @CreateEmployees
  Scenario: Creating an employee
    Given A request is prepared to create an employee
    When A POST call is made to create an employee
    Then The status code for creating an employee is 201
    And The employee is created contains key "Message" and value "Entry Created"
    And The employee ID "Employee[0].employee_id"is stored as a global variable to be used for other calls

 # @APIworkflow
 @CreateEmployees
  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code retrieving the created employee is 200
    And the retrieved employee ID "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" matches the data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title         | emp_status |
      | SyntaxStudent | SBS             | BatchSeven   | 2000-10-10   | Female     | Application Developer | Employee   |

  @Progression
  Scenario: Retrieving all employees and verifying that created employee details display in the response
    Given a request is prepared to retieve all employees
    When a GET call is made to retrieve all employees
    Then the satus code for retrieving all employees is 200
    And the retrieved data contains the globally stored employee ID
    And the retrieved dat matches the data that was used to create an employee