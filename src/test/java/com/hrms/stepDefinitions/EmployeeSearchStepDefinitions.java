package com.hrms.stepDefinitions;

import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchStepDefinitions extends CommonMethods {
	@When("Navigate to employee list")
	public void navigate_to_employee_list() {
	  click(dash.pimLinkBtn);
	  
	}

	@When("Enter a vlid Employee ID {string}")
	public void enter_a_vlid_Employee_ID(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Click on search Button")
	public void click_on_search_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Verify the table is dislayed")
	public void verify_the_table_is_dislayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Get first name from the table")
	public void get_first_name_from_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Get first name from the DB")
	public void get_first_name_from_the_DB() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Validate first names from ui against DB")
	public void validate_first_names_from_ui_against_DB() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
