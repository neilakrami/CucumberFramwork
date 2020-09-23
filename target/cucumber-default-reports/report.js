$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddEmployees.feature");
formatter.feature({
  "name": "Add Employee",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@addEmployee"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Login with valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.LoginStepDefinitions.login_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to add employee page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.navigate_to_add_employee_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add employee without login details but with middle name",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addEmployee"
    },
    {
      "name": "@parameter"
    }
  ]
});
formatter.step({
  "name": "Enter first name as \"Ahmet\" middle nameas \"Can\" and last name \"Bicer\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.enter_first_name_as_middle_nameas_and_last_name(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on save Button",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.click_on_save_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify that \"Ahmet Can Bicer\" is added successfully",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepDefinitions.AddEmployeeStepDefinitions.verify_that_is_added_successfully(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "Add employee without login details but with middle name");
formatter.after({
  "status": "passed"
});
});