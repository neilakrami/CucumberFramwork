package com.hrms.stepDefinitions;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends CommonMethods {

	@Given("Go to HRMS login page")
	public void go_to_hrms_login_page() {
		setup();
	 
	}

	@When("Login with valid credentials")
	public void login_with_valid_credentials() {
	  sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
	  sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
	  click(login.btnLogin);
	}

	@Then("Verify the dashboard logo is displayed")
	public void verify_the_dashboard_logo_is_displayed() {
		Assert.assertTrue(dash.welcome.isDisplayed());
	}

	@Then("quit the browser")
	public void quit_the_browser() {
		tearDown();
	}
	
	@When("Login with invalid credentials")
	public void login_with_invalid_credentials() {
		login.loginToHrms("Admin2", "Syntax");
		
	}

	@Then("Verify the error message")
	public void verify_the_error_message() {
		Assert.assertTrue(login.spanMessage.isDisplayed());
	}


	@When("Login with empty username")
	public void login_with_empty_username() {
	  sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
	  click(login.btnLogin);
	}

	@Then("Verify the empty username error message")
	public void verify_the_empty_username_error_message() {
	    Assert.assertEquals(login.spanMessage.getText(), "Username CANNOT be Empty");
	}
	
	@When("Login with empty password")
	public void login_with_empty_password() {
	   sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
	   click(login.btnLogin);
	}

	@Then("Verify the empty password  error message")
	public void verify_the_empty_password_error_message() {
		Assert.assertEquals(login.spanMessage.getText(), "Password CANNOT be Empty");
	}

}
