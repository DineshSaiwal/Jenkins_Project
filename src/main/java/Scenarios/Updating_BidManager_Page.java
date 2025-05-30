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

public class Updating_BidManager_Page{
	
	Faker f= new Faker();
	Actions act= new Actions (Base_Class.driver);
	public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	
	public void NavigateToUserManagement() throws InterruptedException  {
		Thread.sleep(1000);
		Base_Class.driver.get("https://qa-bidplan.aptagrim.co/user-management");
	}
	
	
	@FindBy(xpath = "//td[7]/div/div/div/button[1]/span") private List <WebElement> EditIcon;
	
	@FindBy(xpath = "//td[5]/div/div/span")private List <WebElement> Roles;

	public void GetStatus(String role) throws InterruptedException {
	 for (int i = 0; i < Roles.size(); i++) {
	        String UserRole = Roles.get(i).getText();
	        if (UserRole.equalsIgnoreCase(role)) {
	        	Thread.sleep(1000);
	        	EditIcon.get(i).click();
	            break;
	        }	
	    }
	 }
	
	
	@FindBy(name = "username") private WebElement Username;
	public void UpdateUserName() throws InterruptedException  {
		Thread.sleep(1000);
		Username.clear();
		Username.sendKeys(f.name().fullName());
	}
	
	@FindBy(name = "email") private WebElement Email;
	public void UpdateEmail()  {
		wait.until(driver -> Email.isDisplayed() && Email.isEnabled());
		Email.clear();
		Email.sendKeys(f.internet().emailAddress());
	}
	
	@FindBy(xpath = "//input[@placeholder='Select']") private WebElement ClickRole;
	public void ClickRole()  {
		wait.until(ExpectedConditions.visibilityOf(ClickRole)).click();
	}
	
	
	@FindBy(xpath = "//div[@role='option']") private List <WebElement> RoleList;
	public void SelectRole(String Role) throws InterruptedException  {
		for (WebElement role:RoleList) {
			Thread.sleep(1000);
			if (role.getText().equalsIgnoreCase(Role)) {
				wait.until(ExpectedConditions.visibilityOf(role)).click();
	            break;
			}
		}
		
	}

	@FindBy(xpath = "//span[contains(text(),'Save Changes')]") private WebElement SaveChanges;
	public void SaveChanges()  {
		wait.until(ExpectedConditions.visibilityOf(SaveChanges)).click();
	}
	
	
	public Updating_BidManager_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
