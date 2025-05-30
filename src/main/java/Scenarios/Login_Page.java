package Scenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base_Package.Base_Class;
import Base_Package.Utility_Class;

public class Login_Page {

	
	@FindBy(name = "email") private WebElement S_Admin_Mail;
	public void Super_Admin_Mail() throws IOException {
		S_Admin_Mail.sendKeys(Utility_Class.getCellData("Credentials", 2, 1));
	}
	
	@FindBy(name = "email") private WebElement Admin_Mail;
	public void Admin_Mail() throws IOException {
		Admin_Mail.sendKeys(Utility_Class.getCellData("Credentials", 2, 2));
	}
	
	@FindBy(name = "email") private WebElement Bid_Manager_mail;
	public void Bid_Manager_mail() throws IOException {
		Bid_Manager_mail.sendKeys(Utility_Class.getCellData("Credentials", 2, 3));
	}
	
	@FindBy(name = "email") private WebElement Team_Member_mail;
	public void Team_Member_mail() throws IOException {
		Team_Member_mail.sendKeys(Utility_Class.getCellData("Credentials", 2, 4));
	}
	
	@FindBy(name = "password") private WebElement PWD;
	public void EnterPWD() throws IOException {
		PWD.sendKeys(Utility_Class.getCellData("Credentials", 3, 1));
	}
	
	
	@FindBy(xpath = "//span[contains(text(),'Sign in')]") private WebElement SignIn;
	public void ClickSignIn() {
		SignIn.click();
	}
	
	WebDriverWait wait = new WebDriverWait(Base_Class.driver, Duration.ofSeconds(20));

	public void URL_Validation() {
	    wait.until(ExpectedConditions.urlToBe("https://qa-bidplan.aptagrim.co/dashboard"));
	    String actualURL = Base_Class.driver.getCurrentUrl();
	    Assert.assertEquals(actualURL, "https://qa-bidplan.aptagrim.co/dashboard");
	}
	
	
	public Login_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
