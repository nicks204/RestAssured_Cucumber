package test;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StepDef {
	
	Response response;
	RequestSpecification request;
	
	@Given("^The \"([^\"]*)\" for Get Operation$")
	public void the_something_for_get_operation(String baseuri) throws Throwable {
		
		request = RestAssured.given()
							.baseUri(baseuri);
	    
	}
	
	 @Given("^The \"([^\"]*)\" for Post Operation and token is \"([^\"]*)\"$")
	 public void the_something_for_post_operation_and_token_is_something(String baseuri, String token) throws Throwable {
		 
		 request = RestAssured.given()
					.baseUri(baseuri)
					.contentType(ContentType.JSON)
	                .auth()
	                .oauth2(token)
	                .body("{\r\n"
	                		+ "    \"name\": \"Postman3\",\r\n"
	                		+ "    \"desription\": \"Test Repo\",\r\n"
	                		+ "    \"homepage\": \"https://github.com/\",\r\n"
	                		+ "    \"private\": false,\r\n"
	                		+ "    \"has_issues\": true,\r\n"
	                		+ "    \"has_projects\": true,\r\n"
	                		+ "    \"has_wiki\": true\r\n"
	                		+ "\r\n"
	                		+ "}");
	        
	 }
	 
	 @Given("^The \"([^\"]*)\" for Patch Operation and token is \"([^\"]*)\"$")
	 public void the_something_for_patch_operation_and_token_is_something(String baseuri, String token) throws Throwable {
		 
		 request = RestAssured.given()
					.baseUri(baseuri)
					.contentType(ContentType.JSON)
	                .auth()
	                .oauth2(token)
	                .baseUri(baseuri)
	                .body("{\r\n"
	                		+ "    \"name\": \"Postman2\",\r\n"
	                		+ "    \"desription\": \"Test Repo\",\r\n"
	                		+ "    \"homepage\": \"https://github.com/\",\r\n"
	                		+ "    \"private\": false,\r\n"
	                		+ "    \"has_issues\": true,\r\n"
	                		+ "    \"has_projects\": true,\r\n"
	                		+ "    \"has_wiki\": true\r\n"
	                		+ "\r\n"
	                		+ "}");
	        
	 }
	
	 

	 
	@When("^User perform the Get Operation$")
	public void user_poerform_the_get_operation() throws Throwable {
		
		response = request.get();
		
		String responseString = response.then().extract().asString();
		
		System.out.println(responseString);
	    
	}
	
	@When("^User perform the Post Operation$")
    public void user_perform_the_post_operation() throws Throwable {
		
		response = request.post();
		
		String responseString = response.then().extract().asString();
		
		System.out.println(responseString);
       
    }
	
	@When("^User perform the Patch Operation$")
    public void user_perform_the_pactch_operation() throws Throwable {
		
		response = request.patch();
		
		String responseString = response.then().extract().asString();
		
		System.out.println(responseString);
       
    }
	
	
	
	
	@Then("^Response should not be null$")
	public void resonse_shouldnot_be_null() throws Throwable {
		
		Assert.assertNotNull(response);
	    
	}
	
	@And("^\"([^\"]*)\" should be as expected$")
	public void something_should_be_as_expected(int responsecode) throws Throwable {
	    
		Assert.assertEquals(responsecode, response.getStatusCode());
		
	}

}
