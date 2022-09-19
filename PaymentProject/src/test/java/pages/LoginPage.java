package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//input[@type='submit']") WebElement login;
	@FindBy(linkText= "Log Out")WebElement logout;

	
	public void loginToApplication(String userName, String  userPassword) {
		
		uname.sendKeys(userName);
		pass.sendKeys(userPassword);
		login.click();
	}
	public void logoutToApplication() {	
		logout.click();
	}

	
}
