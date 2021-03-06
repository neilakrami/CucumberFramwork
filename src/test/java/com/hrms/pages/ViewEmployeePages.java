package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewEmployeePages extends BaseClass{

		@FindBy(id = "menu_pim_viewEmployeeList")
		public WebElement EmployeeListBtn;
		
		@FindBy(id = "empsearch_id")
		public WebElement idTextBox;
		
		@FindBy(id = "empsearch_employee_name_empName")
		public WebElement employeeNameTextBox;
		@FindBy(id = "empsearch_id")
		public WebElement EmpIdTextBox;	
		
		@FindBy(id = "searchBtn")
		public WebElement searchBtn;
		
		@FindBy(xpath = "//table[@id = ‘resultTable’]/tbody/tr/td/a[1]")
		public WebElement idFOundTableResult;
		
		@FindBy(xpath = "//table[@id = ‘resultTable’]/tbody/tr/td/a)[2]")
		public WebElement firstNameFoundTableResult;
		
		@FindBy(xpath = "//table[@id = ‘resultTable’]/tbody/tr/td/a)[3]")
		public WebElement lastNameFoundTableResult;
		
		@FindBy(xpath = "//input[starts-with(@id, ‘ohrmList_chkSelectRec’)])[1]")
		public WebElement firstCheckBox;
		
		@FindBy(css = "input.delete")
		public WebElement deleteBtn;
		
		@FindBy(css = "input#dialogDeleteBtn" )
		public WebElement confirmDeleteBtn;
		
		@FindBy(xpath = "//td[text()=‘No Record Found’]")
		public WebElement noRecordMessage;
		
		@FindBy(xpath = "//td[@class=\"left\"][1]")
		public WebElement empIdLink;
		
		public void EmployeeListPageElements() {
			PageFactory.initElements(driver, this);
		}
		
		
	
}
