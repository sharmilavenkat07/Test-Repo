package org.api.page;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class UsingTestNG {
	public void getMethod() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification requestSpecification = RestAssured.given();
		Response request = requestSpecification.request(Method.GET);
		System.out.println(request.asPrettyString());
		System.out.println(request.getStatusCode() + request.getStatusLine());
		;
	}
@Test
public void postMethod() {
	RestAssured.baseURI = "https://reqres.in/api/users";
	RequestSpecification requestSpecification = RestAssured
			.given().header("Content-Type","application/json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}");
	Response request = requestSpecification.request(Method.POST);
	System.out.println(request.asPrettyString());
	System.out.println(request.getStatusCode()  + request.getStatusLine());
}
	@Test
public void putMethod() {
	RestAssured.baseURI = "https://reqres.in/api/users/2";
	RequestSpecification requestSpecification1 = RestAssured.given().header("Content-Type","application/json")
	.body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"zion resident\"\r\n"
			+ "}");
	Response request1 = requestSpecification1.request(Method.PUT);
	System.out.println(request1.asPrettyString());
	System.out.println(request1.getStatusLine() + request1.getStatusCode());
}
}
