package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUser {
	WebDriver driver;	

	@FindBy(linkText="Register") WebElement registeruser;
	@FindBy(name="customer.firstName") WebElement fname;
	@FindBy(name="customer.lastName") WebElement lname;
	@FindBy(name="customer.address.street") WebElement address;
	@FindBy(name="customer.address.city") WebElement city;
	@FindBy(name="customer.address.state") WebElement state;
	@FindBy(name="customer.address.zipCode") WebElement zcode;
	@FindBy(name="customer.phoneNumber") WebElement phone;
	@FindBy(name="customer.ssn") WebElement ssn;
	@FindBy(name="customer.username") WebElement username;
	@FindBy(name="customer.password") WebElement password;
	@FindBy(name="repeatedPassword") WebElement confirmpassword;
	@FindBy(xpath="//input[@value='Register']") WebElement register;
	@FindBy(id="customer.username.errors") WebElement error;


	public void userRegisterToApplication(String firstName, String  lastName,String uAddress, String  uCity, String uState, String  zipC,String uPhone, String  sSN, String  userName,String userPwd) {
		registeruser.click();
		fname.click();
		fname.sendKeys(firstName);
		lname.click();
		lname.sendKeys(lastName);
		address.sendKeys(uAddress);
		city.sendKeys(uCity);
		state.sendKeys(uState);
		zcode.sendKeys(zipC);
		phone.sendKeys(uPhone);
		ssn.sendKeys(uState);
		username.sendKeys(userName);
		password.sendKeys(userPwd);
		confirmpassword.sendKeys(userPwd);
		register.click();
		if(error.isDisplayed()) {
			String newuserName = userName + "001x2z";
			username.sendKeys(newuserName);
			password.sendKeys(userPwd);
			confirmpassword.sendKeys(userPwd);
			register.click();
		}
		
	}

}
