package Scenarios;
 
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_Package.Base_Class;

public class Change_Password_Page {
	public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	@FindBy(xpath = "//div/header/div[2]") private WebElement ClickOnIcon;
	public void ClickOnProfileIcon() {
		ClickOnIcon.click();
	}
	
	@FindBy(xpath = "//div[text()='My Profile']") private WebElement ClickMyProfile;
	public void ClickMyProfile() {
		ClickMyProfile.click();
	}
	 
	@FindBy(xpath = "//span[contains(text(),'Update Password')]") private WebElement ClickUpdatePassword;
	public void ClickUpdatePassword() {
		ClickUpdatePassword.click();
	}
	
	@FindBy(xpath = "(//input[@type='password'])[1]") private WebElement old_password;
	@FindBy(xpath = "(//input[@type='password'])[2]") private WebElement new_password;
	@FindBy(xpath = "(//input[@type='password'])[3]") private WebElement confirm_password;
	
	JavascriptExecutor js = (JavascriptExecutor) Base_Class.driver;
	
	public void Enter_Old_Password(String oldPass) throws InterruptedException {
		Thread.sleep(1000);
		old_password.sendKeys(oldPass);
	}

	public void Enter_New_Password(String newPass) throws InterruptedException {
		Thread.sleep(1000);
	    new_password.sendKeys(newPass);
	}

	public void Confirm_Password(String confirmPass) throws InterruptedException {
		Thread.sleep(1000);
	    confirm_password.sendKeys(confirmPass);
	}
	
	@FindBy(xpath = "//span[text()='Save Changes']") private WebElement SaveChange;
	public void ClickOnSaveChange() throws InterruptedException {
		Thread.sleep(1000);
		SaveChange.click();
	}
	
	
	public Change_Password_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
}
