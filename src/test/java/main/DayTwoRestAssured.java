package main;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DayTwoRestAssured {
	//https://reqres.in/api/users/23
	//@Test
	public void secondDatRestOne() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		given().when().get("/users/23").then()
			.assertThat().statusCode(404);
		
		/*
		 * String bodyData = "{\r\n" + "    \"name\": \"morpheus\",\r\n" +
		 * "    \"job\": \"leader\"\r\n" + "}";
		 */
		Map<String, String> bodyDataMap = new HashMap<String, String>();
		bodyDataMap.put("name", "Shailesh");
		bodyDataMap.put("job", "Trainer");

		UserPojo userPojo = new UserPojo();
		userPojo.setName("Ranjita");
		userPojo.setJob("Team Lead");
		System.out.println(userPojo.toString());
		
		
		  given().body(userPojo).when().log().all()
		  .post("/users").then().assertThat().statusCode(201).log().body();
		 
		
		Map<String, String> putData = new HashMap<String, String>();
		putData.put("name", "morpheus");
		putData.put("job", "zion resident");
		//given().body(putData).when().log().body().put("/users/2").then().log().body();
						
		//given().when().delete("/users/2").then().log().all();
	}
	
	@Test
	public void authenticationMethod() {
		loginPojo loginP = new loginPojo("eve.holt@reqres.in", "cityslicka");
		RestAssured.baseURI = "https://reqres.in/api";
		String response = given().body(loginP).when().post("/api/register").then().log().body().extract().body().toString();
		
	}
	
	@Test
	public void testExtract() {
		Response res = given().when().get("https://jsonplaceholder.typicode.com/users").then()
				.contentType(ContentType.JSON).extract().response();
		System.out.println(res.jsonPath().get("username[5]"));
	}
	
	@Test
	public void graphQAExample() {
		RestAssured.baseURI = "https://swapi-graphql.netlify.app";
		String bodyData = "{\"query\":\"{\\n  allFilms {\\n    films {\\n      title\\n    }\\n  }\\n}\",\"variables\":null}";
		
		given().body(bodyData).contentType("application/json").when().post("/.netlify/functions/index")
		.then().log().all().assertThat().statusCode(200);
		
		
		
	}
	
	

}
