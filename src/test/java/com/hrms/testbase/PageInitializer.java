package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ViewEmployeePages;
import com.hrms.utils.APICommonMethods;

public class PageInitializer extends BaseClass{
	
	protected static LoginPageElements login;
	protected static DashboardPageElements dash;
	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements persDetails;
	protected static ViewEmployeePages viewEmp;
	protected static APICommonMethods apiMethods;
	
	public static void initializePageObjects() {
		login= new LoginPageElements();
		dash = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		persDetails = new PersonalDetailsPageElements();
		viewEmp = new ViewEmployeePages();
		apiMethods = new APICommonMethods();
	}

}
