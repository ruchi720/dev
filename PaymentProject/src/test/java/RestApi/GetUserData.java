package RestApi;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserData {
	@Test

	public void getUserData() {
		RestAssured.baseURI = "https://randomuser.me/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response =  httpRequest.get();
		//String data = response.prettyPrint();
		
		int code = response.getStatusCode();
		ArrayList<String> data =response.path("results"); 
		//data.contains("first");
		//JsonPath data = response.jsonPath();
		//String name =data.get("first");

		//String name = response.then().extract().path("results");
		//System.out.println("stats code is "+code);
		Assert.assertEquals(code, 200);		

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + 	data);

		

	}
}
