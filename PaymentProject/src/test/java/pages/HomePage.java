package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	@FindBy(linkText="Bill Pay") WebElement paybill;
	@FindBy(xpath="//input[@value='Send Payment']") WebElement makepayment;
	@FindBy(name="payee.name") WebElement payeename;
	@FindBy(name="payee.address.street") WebElement address;
	@FindBy(name="payee.address.city") WebElement city;
	@FindBy(name="payee.address.state") WebElement state;
	@FindBy(name="payee.address.zipCode") WebElement zcode;
	@FindBy(name="payee.phoneNumber") WebElement phone;
	@FindBy(name="payee.accountNumber") WebElement ac;
	@FindBy(name="verifyAccount") WebElement verifyAC;

	@FindBy(name="amount") WebElement amount;
	public void customerBillPayment(String name, String uAddress, String  uCity, String ustate, String  zipcode, String uphone, String  acountNumber, String amounttosend) {
		paybill.click();
		payeename.sendKeys(name);
		address.sendKeys(uAddress);
		city.sendKeys(uCity);
		state.sendKeys(ustate);
		zcode.sendKeys(zipcode);
		phone.sendKeys(uphone);
		ac.sendKeys(acountNumber);
		verifyAC.sendKeys(acountNumber);
		amount.sendKeys(amounttosend);
		makepayment.click();

	}
	
	public void getScreenShot() {
	      try {
	            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	             FileHandler.copy(scrFile, new File("./Screenshot/test.png"));
	         } catch (IOException e) {
	             e.printStackTrace();
	            }
	  }

}
