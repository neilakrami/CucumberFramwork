package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {

	/*
	 * REST Assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request When - What action will you perform, what type
	 * of call are you making? Then - Verification
	 * 
	 */

	/**Concatenates with endpoint during run*/
	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM2MzQxMjUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzY3NzMyNSwidXNlcklkIjoiMTI2MyJ9.oUPvcoBRVVj5LzkKszRNWQDrYSUh21CzBDMSkNfUflw";
	static String employeeID;

	// @Test
	public void sampleTest() {

		/** BaseURI for all endpoints */
		// RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/** JWT */

		/** Preparing request for /getOneEmployee.php */
		/** Using .log.all to print out everything being sent with the request */
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee_id", "3695").log().all();

		/** Making call to /getOneEmployee.php */
		Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One way to print response object */
		// System.out.println(getOneEmployeeResponse.asString());

		/** Second way using rest assured prettyPrint() */
		getOneEmployeeResponse.prettyPrint();

		/** Using assertThat() to verify status code */
		getOneEmployeeResponse.then().assertThat().statusCode(200);
	}

	@Test
	public void aPOSTcreateEmployee() {

		/** Preparing request for creating an employee */
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\n" + "  \"emp_firstname\": \"syntaxFirstName\",\n"
						+ "  \"emp_lastname\": \"syntaxLastName\",\n" + "  \"emp_middle_name\": \"syntaxMiddleName\",\n"
						+ "  \"emp_gender\": \"F\",\n" + "  \"emp_birthday\": \"2000-07-11\",\n"
						+ "  \"emp_status\": \"Employee\",\n" + "  \"emp_job_title\": \"Cloud Architect\"\n" + "}");

		/** making call to /createEmployee.php */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		//Response createEmployeeResponse = createEmployeeRequest.when().log().all().post("/createEmployee.php");
		/** Printing response */
		//createEmployeeResponse.prettyPrint();

		/**
		 * Using jsonPath() to view the response body which lets us get the employee ID
		 * We are storing the employeeID as a static global variable to be able to use
		 * with other calls
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		/** Optional: Printing employeeID */
		//System.out.println(employeeID);

		/** Verifying status code is 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying response body "Message" is paired with "Entry Created"; equalTo()
		 * method comes from static Hamcrest package - NEED TO IMPORT MANUALLY import
		 * static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/** Verifying created employee first name */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("syntaxFirstName"));

		/** Verifying server Apache/2.4.39 (Win64) PHP/7.2.18 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
	}

	@Test
	public void bGETcreatedEmployee() {

		

		/** Preparing request to get created employee */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID);
		
		/**Storing response for retrieving created employee */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		/** Printing response */
		//getCreatedEmployeeResponse.prettyPrint();
		
		/** Storing response employee ID into empID to compare with static global employee ID*/
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		/** Comparing empID with stored employeeID from created employee call */
		boolean verifyingEmployeeID = empID.equalsIgnoreCase(employeeID);
		
		/** Asserting to verify the above condition is true */
		Assert.assertTrue(verifyingEmployeeID);
		
		/** Verifying status code is 200 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		/** Created object of JsonPath */
		String response = getCreatedEmployeeResponse.asString();
		JsonPath js = new JsonPath(response);

		/** Grabbing employee ID using 'js'*/
		String employeeId = js.getString("employee[0].employee_id");
		String employeeFirstName = js.getString("employee[0].emp_firstname");
		String employeeMiddleName = js.getString("employee[0].emp_middle_name");
		String employeeLastName = js.getString("employee[0].emp_lastname");
		String employeeDOB = js.getString("employee[0].emp_birthday");
		String employeeGender = js.getString("employee[0].emp_gender");
		String employeeJobTitle = js.getString("employee[0].emp_job_title");
		String employeeStatus = js.getString("employee[0].emp_status");
		
		/** Asserting response employee ID matches stored employee*/
		Assert.assertTrue(employeeId.contentEquals(employeeID));

		
		/** Asserting the rest of the values match expected data*/
		Assert.assertEquals(employeeFirstName, "syntaxFirstName");
		Assert.assertEquals(employeeMiddleName, "syntaxMiddleName");
		Assert.assertEquals(employeeLastName, "syntaxLastName");
		Assert.assertEquals(employeeDOB, "2000-07-11");
		Assert.assertEquals(employeeGender, "Female");
		Assert.assertEquals(employeeJobTitle, "Cloud Architect");
		Assert.assertEquals(employeeStatus, "Employee");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@Test
	public void cGETallEmployees() {
		
		/** Preparing request to get all employees*/
			RequestSpecification getAllEmployeesRequest = given().header("Content-Type", "application/json")
					.header("Authorization", token);
			/** Storing response into getAllEMployeesResponse*/
			Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");
			
			/**Printing response */
			//getAllEmployeesResponse.prettyPrint();

			/** Storing response as a String */
			String response = getAllEmployeesResponse.asString();
			
			/** Creating object of JsonPath and passing response as a  String as an argument */
			JsonPath js = new JsonPath(response);
			
			
			/** Retrieving the size of the array (the number of object in the array)*/
			int count = js.getInt("Employees.size()");
			//System.out.println(count);
//			
//			for(int i = 0; i < count; i++) {
//				
//				String allEmplloyeeIDs= js.getString("Employees[" + i + "].employee_id");
//				//System.out.println(allEmplloyeeIDs);
//				if(allEmplloyeeIDs.contentEquals(employeeID)) {
//					//System.out.println("Employee ID " + employeeID + " is present in the body");
//					String firstNameOfEmpID = js.getString("Employees[" + i + "].emp_firstname");
//					
//					//System.out.println(firstNameOfEmpID);
//					break;
//				}
//				
//			}
//			
//			/** for loop to print out first name of all employees */
//			for(int i = 0; i < count; i++) {
//				String allEmployeeName = js.getString("Employees[" + i +"].emp_firstname");
//				System.out.println(allEmployeeName);
			}
			@Test
			public void dPUTupdateCreatedEmployee() {			
				
				/** Preparing request to PUT Updated all employees*/
				RequestSpecification PUTUpdatedAllEmployeesRequest = given().header("Content-Type", "application/json")
						.header("Authorization", token).body("{\n"
								+ "  \"employee_id\": \""+ employeeID+ "\",\n"
								+ "  \"emp_firstname\": \"Postman\",\n"
								+ "  \"emp_lastname\": \"API\",\n"
								+ "  \"emp_middle_name\": \"postman\",\n"
								+ "  \"emp_gender\": \"F\",\n"
								+ "  \"emp_birthday\": \"2000-10-17\",\n"
								+ "  \"emp_status\": \"Independent contractor\",\n"
								+ "  \"emp_job_title\": \"Cloud Architect\"\n"
								+ "}").log().all();
				
				/** Storing response into PUTUpdatedAllEMployeesResponse*/
				Response PUTUpdatedAllEmployeesResponse = PUTUpdatedAllEmployeesRequest.when().put("/updateEmployee.php");
				
				PUTUpdatedAllEmployeesResponse.prettyPrint();
				
				
				String response = PUTUpdatedAllEmployeesResponse.asString();
				
				JsonPath js = new JsonPath(response);
				
			
				/** Grabbing employee ID using 'js'*/
				String employeeId = js.getString("employee[0].employee_id");
				String employeeFirstName = js.getString("employee[0].emp_firstname");
				String employeeMiddleName = js.getString("employee[0].emp_middle_name");
				String employeeLastName = js.getString("employee[0].emp_lastname");
				String employeeDOB = js.getString("employee[0].emp_birthday");
				String employeeGender = js.getString("employee[0].emp_gender");
				String employeeJobTitle = js.getString("employee[0].emp_job_title");
				String employeeStatus = js.getString("employee[0].emp_status");
				
				Assert.assertTrue(employeeId.contentEquals(employeeID));
				
				
				/** Asserting the rest of the values match expected data*/
				Assert.assertEquals(employeeFirstName, "Postman");
				Assert.assertEquals(employeeMiddleName, "postman");
				Assert.assertEquals(employeeLastName, "API");
				Assert.assertEquals(employeeDOB, "2000-10-17");
				Assert.assertEquals(employeeGender, "Female");
				Assert.assertEquals(employeeJobTitle, "Cloud Architect");
				Assert.assertEquals(employeeStatus, "Independent contractor");
			
		}
			


}



