package Scenarios;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base_Package.Base_Class;

public class Inactive_Client_Page {

public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
Actions act= new Actions (Base_Class.driver);
private static final Logger logger = Logger.getLogger(Add_Client_Page.class.getName());


		
//		@FindBy(xpath = "(//div[@class='flex flex-col w-full '])[2]") private WebElement Hover;
//		public void Hover() throws IOException {
//			logger.info("Attempting to Hover on Settings");
//			act.moveToElement(Hover).perform();
//			logger.info("Hovered on Settings");
//	    }
//		
//		@FindBy(xpath = "//span[contains(text(),'Settings')]") private WebElement Settings;
//		public void ClickOnSettings()  {
//			logger.info("Attempting to Click on Settings");
//			act.click(Settings);
//			logger.info("Clicked on Settings");
//		}


		public void NavigateToClientmanagement()  {
			Base_Class.driver.get("https://qa-bidplan.aptagrim.co/clientmanagement?view=list");
		}
	
//		@FindBy(xpath = "//span[contains(text(),'Client Management')]") private WebElement ClientManagement;
//		public void ClickOnClientManagement()  {
//			act.click(ClientManagement).perform();
//		}
		
		@FindBy(xpath = "//td[8]/div/button[@type='button']") private List <WebElement> ThreeDots;
		
		@FindBy(xpath = "//td[6]/div/div/span")private List <WebElement>statuses;
	
	public void GetStatus(String Status) throws InterruptedException {
	 for (int i = 0; i < statuses.size(); i++) {
	        String clientStatus = statuses.get(i).getText();
	        if (clientStatus.equalsIgnoreCase(Status)) {
	        	Thread.sleep(2000);
	        	ThreeDots.get(i).click();
	            break;
	        }	
	    }
	 }
	
	
	
	@FindBy(xpath = "//div[contains(text(),'Inactive')]") private WebElement ClickInactive;
	public void ClickInactive()  {
		wait.until(ExpectedConditions.visibilityOf(ClickInactive)).click();
	}
	
	
	@FindBy(xpath = "//span[text()='Confirm']") private WebElement Confirm;
	public void Confirm()  {
		wait.until(ExpectedConditions.visibilityOf(Confirm)).click();
	}
	
	
	public Inactive_Client_Page(WebDriver driver) {
		PageFactory.initElements(driver,this); 
	}
}
