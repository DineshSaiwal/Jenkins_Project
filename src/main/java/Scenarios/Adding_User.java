package Scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import Base_Package.Base_Class;

public class Adding_User{
	Faker f= new Faker();
	Actions act= new Actions (Base_Class.driver);
	public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	
	public void NavigateToClientmanagement() throws InterruptedException  {
		Thread.sleep(1000);
		Base_Class.driver.get("https://qa-bidplan.aptagrim.co/user-management");
	}
	
	@FindBy(xpath = "//span[contains(text(),'Add User')]") private WebElement AddUser;
	public void AddUser()  {
		wait.until(ExpectedConditions.visibilityOf(AddUser)).click();
	}
	
	@FindBy(name = "username") private WebElement Username;
	public void EnterUserName()  {
		wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(f.name().fullName());
	}
	
	@FindBy(name = "email") private WebElement Email;
	public void EnterEmail()  {
		wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(f.internet().emailAddress());
	}
	
	@FindBy(xpath = "//input[@placeholder='Select']") private WebElement ClickRole;
	public void ClickRole()  {
		wait.until(ExpectedConditions.visibilityOf(ClickRole)).click();
	}
	
	@FindBy(xpath = "//div[@role='option']") private List <WebElement> Roles;
	public void SelectRole(String Role) throws InterruptedException  {
		for (WebElement role:Roles) {
			Thread.sleep(1000);
			if (role.getText().equalsIgnoreCase(Role)) {
				wait.until(ExpectedConditions.visibilityOf(role)).click();
	            break;
			}
		}
		
	}

	@FindBy(xpath = "//span[contains(text(),' Add User')]") private WebElement AddButton;
	public void ClickAddButton()  {
		wait.until(ExpectedConditions.visibilityOf(AddButton)).click();
	}
	
	
	public Adding_User(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
