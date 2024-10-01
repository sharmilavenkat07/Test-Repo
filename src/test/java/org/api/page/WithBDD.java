package org.api.page;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.apache.commons.collections4.Get;
import org.testng.annotations.Test;

public class WithBDD {
	@Test
	public void withBdd() {
		given().baseUri("https://reqres.in/api/users?page=2")
		.when().get().asPrettyString();
		System.out.println(get().statusCode());
	}
@Test
	public void postMethod() {
		given().basePath("https://reqres.in/api/users")
		.header("Content-Type"
, "application/json").body("{\r\n"
		+ "    \"name\": \"morpheus\",\r\n"
		+ "    \"job\": \"leader\"\r\n"
		+ "}").when().post().prettyPrint();
	}
@Test
public void extractbodyFile() {
	File getbody= new File("body.json");
	given().baseUri("https://reqres.in/api/users/2")
	.header("Content-Type"
					, "application/json")
	.body(getbody).when().put().prettyPrint();
}
}