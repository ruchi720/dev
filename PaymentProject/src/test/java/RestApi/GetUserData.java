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
		int code = response.getStatusCode();
		ArrayList<String> data =response.path("results"); 
		Assert.assertEquals(code, 200);		

		System.out.println("City received from Response " + 	data);

		

	}
}
