package com.hrms.stepDefinitions;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AddEmployeeStepDefinitions extends CommonMethods{

	@Then("Navigate to add employee page")
	public void navigate_to_add_employee_page() {
	 click(dash.pimLinkBtn);
	 click(dash.addEmpBtn);
	}

	@Then("Enter firs and last name")
	public void enter_firs_and_last_name() {
		sendText(addEmp.firstNameField, "John");
		sendText(addEmp.lastNameField, "Wick");
	}

	@Then("Click on save Button")
	public void click_on_save_Button() {
		click(addEmp.saveButton);
	}

	@Then("Verify the employee is added successfully")
	public void verify_the_employee_is_added_successfully() {
	   String profileName = persDetails.profileName.getText();
	   Assert.assertEquals("John Wick", profileName);
	}

	@When("Enter first name as {string} middle nameas {string} and last name {string}")
	public void enter_first_name_as_middle_nameas_and_last_name(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastNameField, lastName);
	}
	
	@Then("Verify that {string} is added successfully")
	public void verify_that_is_added_successfully(String fullName) {
		 String profileName = persDetails.profileName.getText();
		   Assert.assertEquals(fullName, profileName);
		
	}
	
	@When("enter employee {string}, {string} and {string}")
	public void enter_employee_and(String firstName, String middleName, String lastName) {
		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastNameField, lastName);
	}

	@Then("Verify that {string}, {string} and {string} is successfully added")
	public void verify_that_and_is_successfully_added(String firstName, String middleName, String lastName) {
	    String fullName = firstName = " " + middleName + " " + " " + lastName;
	    String fullProfilename = persDetails.profileName.getText();
	    Assert.assertEquals(fullName, fullProfilename);
	}
	
	@When("add multiple employees and verify they are added")
	public void add_multiple_employees_and_verify_they_are_added(DataTable employees) throws InterruptedException {
	 List<Map<String, String>> employeesNames =  employees.asMaps();
	 
	 for (Map<String, String> employeeName : employeesNames) {
		String firstName =  employeeName.get("First Name");
		String middleName = employeeName.get("Middle Name");
		String lastName = employeeName.get("Last Name");
		String empID = employeeName.get("Employee ID");

		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.middleName, middleName);
		sendText(addEmp.lastNameField, lastName);
		sendText(addEmp.idField, empID);
		click(addEmp.saveButton);
		
		String actualName = persDetails.profileName.getText();
		String expectedName = firstName + " " + middleName+ " " + lastName;
		Assert.assertEquals("Verifying employee names", expectedName, actualName);
		click(dash.addEmpBtn);
		Thread.sleep(1000);
	  }
	}
	
	
	@When("Add multiple employees from {string} verify they are added successfully")
	public void add_multiple_employees_from_verify_they_are_added_successfully(String sheetName) throws InterruptedException {
		List<Map<String, String>> excelData = ExcelUtility.excelToListMap(Constants.TESTDATA_FILEPATH, sheetName);
	  
		for (Map<String, String> excelEmpName : excelData) {
			String firstName =  excelEmpName.get("First Name");
			String middleName = excelEmpName.get("Middle Name");
			String lastName = excelEmpName.get("Last Name");
			String empID = excelEmpName.get("Employee ID");
			
			sendText(addEmp.firstNameField, firstName);
			sendText(addEmp.middleName, middleName);
			sendText(addEmp.lastNameField, lastName);
			sendText(addEmp.idField, empID);
			click(addEmp.saveButton);
			
			String actualName = persDetails.profileName.getText();
			String expectedName = firstName + " " + middleName+ " " + lastName;
			Assert.assertEquals("Verifying employee names", expectedName, actualName);
			jsClick(dash.addEmpBtn);
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
}
