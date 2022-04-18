package main;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstRestAssuredClass {

	// @Test
	public void firstRestMethod() {
		/*
		 * String postBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" +
		 * "    \"job\": \"leader\"\r\n" + "}";
		 */
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		/*
		 * RequestSpecification req = RestAssured.given(); Response response =
		 * req.request(Method.GET, "/todos/1");
		 */
		Response response = RestAssured.given().when().get("/");
		System.out.println("Response Code = " + response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		// Assert.assertEquals(response.getStatusCode(), 200);
		// System.out.println(response.getHeaders());
	}

	@Test
	public void secondRestAssuredMethod() {
		RestAssured.baseURI = "https://reqres.in/api";

		/*
		 * given().queryParam("page", "1") .when() .get("/users") .then().log().all()
		 * .assertThat() .statusCode(200) .body("page", equalTo(1))
		 * .body("data.first_name", hasItems("George", "Tracey", "Charles"))
		 * .body("total", greaterThan(10));
		 */

		Map<String, String> bodyData = new HashMap<String, String>();
		bodyData.put("email", "eve.holt@reqres.in");
		bodyData.put("password", "pistol");

		given().contentType("application/json").body(bodyData).when().post("/register").then().log().body();

	}

//	@Test
	public void xmlRequest() {
		RestAssured.baseURI = "http://localhost:8080";
		given().when().get("/bar").then().log().all().body(":foo.:bar.text()", equalTo("sudo "));
	}
	
	

}
