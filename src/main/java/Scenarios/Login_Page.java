package Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base_Package.Base_Class;

public class Login_Page {

	
	@FindBy(name = "email") private WebElement UN;
	public void EnterUN() {
		UN.sendKeys("dinesh.saiwal@aptagrim.com");
	}
	
	
	@FindBy(name = "password") private WebElement PWD;
	public void EnterPWD() {
		PWD.sendKeys("Abcd.1234");
	}
	
	@FindBy(xpath = "//span[contains(text(),'Sign in')]") private WebElement SignIn;
	public void ClickSignIn() {
		SignIn.click();
	}
	
	public void URL_VAlidation() {
		Base_Class.driver.getCurrentUrl();
		Assert.assertEquals(Base_Class.driver.getCurrentUrl(), "https://qa-bidplan.aptagrim.co/dashboard");
	}
	
	
	public Login_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
