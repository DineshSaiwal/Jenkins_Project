package Scenarios;

import java.awt.AWTException;
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



public class Add_Client_Page {
	
	Faker f= new Faker();
	Actions act= new Actions (Base_Class.driver);
	public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	

//	@FindBy(xpath = "(//div[@class='flex flex-col w-full '])[2]") private WebElement Hover;
//	public void SidePanelHover() throws InterruptedException {
//		Thread.sleep(2000);	Hover.click();
//	}
	
	
//	@FindBy(xpath = "//span[contains(text(),'Settings')]") private WebElement Settings;
//	public void ClickOnSettings()  {
//		Settings.click();
//	}
	

		
//	@FindBy(xpath = "//span[contains(text(),'Client Management')]") private WebElement ClientManagement;
//	public void ClickOnClientManagement()  {
//		ClientManagement.click();
//	}
	
	public void NavigateToClientmanagement() throws InterruptedException  {
		Thread.sleep(1000);
		Base_Class.driver.get("https://qa-bidplan.aptagrim.co/clientmanagement?view=list");
	}
	
	@FindBy(xpath = "//span[contains(text(),'Add new Clients')]") private WebElement AddnewClients;
	public void ClickOnAddNewClient()  {
		wait.until(ExpectedConditions.visibilityOf(AddnewClients)).click();
	}
	
	
	@FindBy(xpath = "//input[@type='file']") private WebElement Upload;
	public void UploadFile() throws AWTException, InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(Upload)).sendKeys(System.getProperty("user.dir")+"/Files/Youtube.png");
	}
	
	@FindBy(name = "username") private WebElement Username;
	public void EnterUserName()  {
		wait.until(ExpectedConditions.visibilityOf(Username)).sendKeys(f.name().fullName());
		
	}
	
	@FindBy(name = "email") private WebElement Email;
	public void EnterEmail()  {
		wait.until(ExpectedConditions.visibilityOf(Email)).sendKeys(f.internet().emailAddress());
	}
	
	@FindBy(name = "company_title") private WebElement company_title;
	public void EnterCompanyTitle()  {
		wait.until(ExpectedConditions.visibilityOf(company_title)).sendKeys(f.company().name());
		}
	
	@FindBy(name = "phone_number") private WebElement phone_number;
	public void EnterPhoneNumber()  {
		wait.until(ExpectedConditions.visibilityOf(phone_number)).sendKeys(f.phoneNumber().subscriberNumber(10));
	}
	
	@FindBy(name = "website") private WebElement Website;
	public void EnterWebsite()  {
		wait.until(ExpectedConditions.visibilityOf(Website)).sendKeys("https://"+f.internet().url());
	}
	
	@FindBy(name = "company_address") private WebElement company_address;
	public void EnterCompanyAddress()  {
		wait.until(ExpectedConditions.visibilityOf(company_address)).sendKeys(f.address().fullAddress());
	}
	
	@FindBy(name = "pincode") private WebElement pincode;
	public void EnterPincode()  {
		wait.until(ExpectedConditions.visibilityOf(pincode)).sendKeys(f.address().zipCode());
	}
	
	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[1]") private WebElement CountryCode;
	public void ClickCountryCode() {
		wait.until(ExpectedConditions.visibilityOf(CountryCode)).click();
	}
	
	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[2]") private WebElement CountryDropdown;
	public void ClickCountryDropdown()  {
		wait.until(ExpectedConditions.visibilityOf(CountryDropdown)).click();
	}
	

	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[3]") private WebElement StateDropdown;
	public void ClickStateDropdown()  {
		wait.until(ExpectedConditions.visibilityOf(StateDropdown)).click();
	}
	
	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[4]") private WebElement CityDropdown;
	public void ClickCityDropdown()  {
		wait.until(ExpectedConditions.visibilityOf(CityDropdown)).click();
	}
	
	@FindBy(xpath = "//div[@role='option']") private List <WebElement> Options;

	public void SelectOption(String Option) throws InterruptedException {
		Thread.sleep(1000);
	    for (WebElement country : Options) {
	        if (country.getText().equalsIgnoreCase(Option)) {
	        	wait.until(ExpectedConditions.visibilityOf(country)).click();
	            break;
	        }
	    }
	}
	
	@FindBy(xpath = "//span[contains(text(),'Add Client')]") private WebElement ClickAddClient;
	public void ClickAddClient()  {
		wait.until(ExpectedConditions.visibilityOf(ClickAddClient)).click();
	}
	
	public Add_Client_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
