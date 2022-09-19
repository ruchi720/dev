package FrontEnd;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.Browser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterUser;

public class E2ETestForPayment {

	WebDriver driver;
	@Test
	public void loginApp() {
		RestAssured.baseURI = "https://randomuser.me/api/";
		RequestSpecification httpRequest = RestAssured.given();
		
		//User1 data as recipient
		Response responseuser2 =  httpRequest.get();
		int responsecode = responseuser2.getStatusCode();
		System.out.println("stats code is "+responsecode);
		Assert.assertEquals(responsecode, 200);		
		String recipient_fName = responseuser2.path("results.name.first").toString();
		String recipient_lName = responseuser2.path("results.name.last").toString();
		String recipient_address = responseuser2.path("results.location.street").toString();
		String recipient_city = responseuser2.path("results.location.city").toString();
		String recipient_state = responseuser2.path("results.location.state").toString();
		String recipient_zipcode = responseuser2.path("results.location.postcode").toString();
		String recipient_phoneNumber = responseuser2.path("results.phone").toString();
		String recipient_ssn = responseuser2.path("results.cell").toString();
		String recipient_username = responseuser2.path("results.login.username").toString();
		String recipient_password = responseuser2.path("results.login.password").toString();
		System.out.println("UserName for Customer2 is "+recipient_username);
		System.out.println("Password for Customer2 is "+recipient_password);
		String name = recipient_fName + recipient_lName;
		String accountNumber = "0987536223";
		//User2 data as sender
		Response response =  httpRequest.get();
		int code = response.getStatusCode();
		System.out.println("stats code is "+code);
		Assert.assertEquals(code, 200);		
		String sender_fName = response.path("results.name.first").toString();
		String sender_lName = response.path("results.name.last").toString();
		String sender_address = response.path("results.location.street").toString();
		String sender_city = response.path("results.location.city").toString();
		String sender_state = response.path("results.location.state").toString();
		String sender_zipcode = response.path("results.location.postcode").toString();
		String sender_phoneNumber = response.path("results.phone").toString();
		String sender_ssn = response.path("results.cell").toString();
		String sender_username = response.path("results.login.username").toString();
		String sender_password = response.path("results.login.password").toString();
		System.out.println("UserName for Customer is "+sender_username);
		System.out.println("Password for Customer is "+sender_password);

		
		driver = Browser.startApplication(driver, "Chrome", "https://parabank.parasoft.com/parabank/index.htm");
		System.out.println(driver.getTitle());
		RegisterUser userRegistration = PageFactory.initElements(driver, RegisterUser.class);
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		userRegistration.userRegisterToApplication(recipient_fName, recipient_lName, recipient_address, recipient_city, recipient_state, recipient_zipcode, recipient_phoneNumber, recipient_ssn, recipient_username, recipient_password);		
		loginpage.logoutToApplication(); 
		userRegistration.userRegisterToApplication(sender_fName, sender_lName, sender_address, sender_city, sender_state, sender_zipcode, sender_phoneNumber, sender_ssn, sender_username, sender_password);		

		homepage.customerBillPayment(name, recipient_address, recipient_city, recipient_state, recipient_zipcode, recipient_phoneNumber,accountNumber,"34567");
		homepage.getScreenShot();
		//Browser.quiteBrowser(driver);
	}
	
	
}
