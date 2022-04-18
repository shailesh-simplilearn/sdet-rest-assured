package rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SerClass {
	
	@Test
	public void serMethod() {
		RestAssured.baseURI = "https://reqres.in/api";
		RestPOJO restPojo = new RestPOJO("Shailesh", "Clerk");
		System.out.println(restPojo.getName());
		given().contentType("application/json").when().body(restPojo).post("/users").then().log().body();
	}

}
