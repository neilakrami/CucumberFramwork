package com.hrms.utils;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class APICommonMethods {
	/** Use this method to create an employee*/
	/**
	 * 
	 */
	public static  RequestSpecification createEmployeeRequest(String token, String createEmployeeBody ) {
		return given().header("Authorization", token).header("Content-Type", "Application/json").body(createEmployeeBody);
		
	}

	/** USe this method to GET and employee*/
	/**
	 * 
	 * @param token
	 * @param employeeID
	 * @return
	 */
	public static RequestSpecification getOneEmployeeRequest(String token, String employeeID) {
		return  given().header("Content-Type", "application/json").header("Authorization",token).param("employee_id", employeeID);
	}
	/** Use this method to generate a token*/
	/**
	 * 
	 * @param generateTokenBody
	 * @return
	 */
	public static RequestSpecification generateTokenRequest(String generateTokenBody) {
		return given().header("Content-Type", "application/json").body(generateTokenBody);

	}
}
