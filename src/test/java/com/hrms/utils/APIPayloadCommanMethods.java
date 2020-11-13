package com.hrms.utils;

import org.json.JSONObject;

public class APIPayloadCommanMethods {
	
	public static String createEmployeeBody() {
		
		
		/** 1st way */
		String createEmployeeBody = "{\n"
				+ "  \n"
				+ "  \"emp_firstname\": \"SyntaxStudent\",\n"
				+ "  \"emp_lastname\": \"BatchSeven\",\n"
				+ "  \"emp_middle_name\": \"SBS\",\n"
				+ "  \"emp_gender\": \"F\",\n"
				+ "  \"emp_birthday\": \"2000-10-10\",\n"
				+ "  \"emp_status\": \"Employee\",\n"
				+ "  \"emp_job_title\": \"Application Developer\"\n"
				+ "}";
		
		return createEmployeeBody;
	}

	
	public static String createEmployeePayload() {
		
		JSONObject obj = new JSONObject();
		
		obj.put("emp_firstname", "SyntaxStudent");
		obj.put("emp_lastname", "BatchSeven");
		obj.put("emp_middle_name", "SBS");
		obj.put("emp_gender", "F");
		obj.put("emp_birthday", "2000-10-10");
		obj.put("emp_status", "Employee");
		obj.put("emp_job_title", "Application Developer");
		return obj.toString();
		
		
	}
	
public static String createEmployeePayloadMoreDynamic
		(String firstName,String lastName, String middleName, String gender,
		String dob, String employeeStatus, String employeeJobTitle) {
		
		JSONObject obj = new JSONObject();
		
		obj.put("emp_firstname", firstName);
		obj.put("emp_lastname", lastName);
		obj.put("emp_middle_name", middleName);
		obj.put("emp_gender", gender);
		obj.put("emp_birthday", dob);
		obj.put("emp_status", employeeStatus);
		obj.put("emp_job_title", employeeJobTitle);
		return obj.toString();
		
		
	}
}
