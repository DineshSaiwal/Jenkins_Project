package Scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_Package.Base_Class;

public class User_Active_Inactive {
	
	
public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	
	public void NavigateToClientmanagement() throws InterruptedException  {
		Thread.sleep(1000);
		Base_Class.driver.get("https://qa-bidplan.aptagrim.co/user-management");
	}
	
@FindBy(xpath = "//td[7]/div/div/div/button[2]/span") private List <WebElement> Active_Inactive_Icon;
	
	@FindBy(xpath = "//td[5]/div/div/span")private List <WebElement> Roles;
	@FindBy(xpath = "//td[6]/div/div/span")private List <WebElement> Statuses;
	public void GetStatus(String role, String Status) throws InterruptedException {
	 for (int i = 0; i < Roles.size(); i++) {
	        String UserRole = Roles.get(i).getText();
	        String UserStatus= Statuses.get(i).getText();
	        if (UserRole.equalsIgnoreCase(role)&&UserStatus.equalsIgnoreCase(Status)) {
	        	Thread.sleep(1000);
	        	Active_Inactive_Icon.get(i).click();
	            break;
	        }	
	    }
	 }
	
	@FindBy(xpath = "//span[text()='Confirm']") private WebElement ClickConfirm;
	public void ClickConfirm()  {
		wait.until(ExpectedConditions.visibilityOf(ClickConfirm)).click();
	}
	
	
	
	public User_Active_Inactive(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
