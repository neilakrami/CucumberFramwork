package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;

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

}
