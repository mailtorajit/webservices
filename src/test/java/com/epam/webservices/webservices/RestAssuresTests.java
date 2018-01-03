package com.epam.webservices.webservices;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RestAssuresTests {
	Response response = null;

	@BeforeClass
	@Parameters({ "domain", "resource" })
	public void setUri(String domainName, String endpoint) {
		RestAssured.baseURI = domainName;
		response = RestAssured.given().get("/" + endpoint).andReturn();
	}

	@Test
	@Parameters({ "statusCode" })
	public void verifyStatusCode(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Test
	@Parameters({ "headerKey", "headerValue" })
	public void verifyResponseContentType(String headerKey, String headerValue) {
		String valueOfContentTypeHeader = response.getHeader(headerKey);
		Assert.assertTrue(valueOfContentTypeHeader.contains(headerValue));
	}

	@Test
	public void verifyContentTypeHeader() {
		assertTrue(response.getHeaders().hasHeaderWithName("Content-Type"));		
	}

	@Test
	public void verifyCountOfEmployees() {
		EmployeeInformation[] empinformation = response.as(EmployeeInformation[].class);
		Assert.assertEquals(empinformation.length, 10);
	}

	@Test
	public void printObjects() {
		EmployeeInformation[] employeesinformation = response.as(EmployeeInformation[].class);
		for (EmployeeInformation empinformation : employeesinformation) {
			System.out.println(empinformation);
		}
	}
}
