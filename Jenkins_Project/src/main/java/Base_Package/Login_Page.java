package Base_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	@FindBy(name = "username" ) private WebElement UserName;
	
	public void EnterUN() {
		UserName.sendKeys("student");
		
	}
	
	@FindBy(name = "password" ) private WebElement Password;
	
	public void Password() {
		Password.sendKeys("Password123");
		
	}
	
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}

