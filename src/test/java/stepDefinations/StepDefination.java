package stepDefinations;


import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.JsonParser;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data =new TestDataBuild();
	JsonParser js = new JsonParser();
	static String place_id, firstName;
	
	@Given("Create User Payload with {string} {string}")
	public void create_User_Payload_with(String name, String email) throws IOException{
		res=given().spec(requestSpecification())
				.body(data.addUserPayLoad(name,email));
	}
	

@Given("Add Place Payload with {string}  {string} {string}")
public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		 res=given().spec(requestSpecification())
		.body(data.addUserPayLoad(name,language));
	}

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
//constructor will be called with value of resource which you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
		 response =res.when().get(resourceAPI.getResource());
		
		
}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		//assertEquals(response.getStatusCode(),int1);
		System.out.println("response code is "+response.getStatusCode());
		System.out.println("expected code is "+int1);
		if(response.getStatusCode() == int1) {
		
			assert(true);
		}else {
			assertFalse("Expected response status code is not same", true);
		}
		
	
	}
	

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    // Write code here that turns the phrase above into concrete actions
	 assertEquals(getJsonPath(response,keyValue),Expectedvalue);
		
		
		
	}
	
	@Then("verify first_name created maps to {string} using {string}")
	public void verify_first_name_created_maps_to_using(String expectedName, String resource) throws IOException {
	
	   // requestSpec
		 System.out.println("expectedName="+expectedName);
		 res=given().spec(requestSpecification()).params("first_name", expectedName);
		 user_calls_with_http_request(resource,"GET");
		 System.out.println("Response from Get Call :: "+response.asString());
		  String actualName=js.getFirstName(response);
		  System.out.println("name returned from GET call is "+actualName);
		  assertEquals(actualName,expectedName);
		 
	    
	}
	

@Given("DeletePlace Payload")
public void deleteplace_Payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions
   
	res =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
}

@Given("GetUserAPI request")
public void getuserapi_request() throws IOException{
    // Write code here that turns the phrase above into concrete actions
	res =given().spec(requestSpecification()).params("first_name", "Fedex");
    
}

@Given("GetUserAPI request with {string} and {string}")
public void getuserapi_request_with_and(String paramName, String paramValue) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	res =given().spec(requestSpecification()).params(paramName, paramValue);
}



}
