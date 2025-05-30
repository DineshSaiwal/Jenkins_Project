package Scenarios;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import Base_Package.Base_Class;

public class Update_Client_Page {
	
	Faker f= new Faker();
	Actions act= new Actions (Base_Class.driver);
	public static WebDriverWait wait =new WebDriverWait(Base_Class.driver, Duration.ofSeconds(5));
	
	public void NavigateToClientmanagement() throws InterruptedException  {
		Thread.sleep(1000);
		Base_Class.driver.get("https://qa-bidplan.aptagrim.co/clientmanagement?view=list");
	}
	
	@FindBy(xpath = "(//div/label[1]/span)[1]") private WebElement Layout;
	public void GirdLayout() throws InterruptedException  {
		Thread.sleep(1000);
		Layout.click();
	}
	
	
	@FindBy(xpath = "(//button/span)[4]") private WebElement ThreeDots;
	public void ClickThreeDots() throws InterruptedException  {
		Thread.sleep(1000);
		ThreeDots.click();
	}
	
	@FindBy(xpath = "//div[contains(text(),'Edit')]") private WebElement ClickEditIcon;
	public void ClickEditIcon()  {
		wait.until(ExpectedConditions.visibilityOf(ClickEditIcon)).click();
	}
	
	@FindBy(xpath = "//input[@type='file']") private WebElement Upload;
	public void UploadFile() throws AWTException, InterruptedException  {
		wait.until(ExpectedConditions.visibilityOf(Upload)).sendKeys(System.getProperty("user.dir")+"/Files/Samsung.png");
	}
	
	@FindBy(name = "username") private WebElement Username;
	public void EnterUserName() throws InterruptedException  {
		wait.until(ExpectedConditions.visibilityOf(Username)).clear();
	    Username.sendKeys(f.name().fullName());
	}
	
	@FindBy(name = "email") private WebElement Email;
	public void EnterEmail(){
		wait.until(ExpectedConditions.visibilityOf(Email)).clear();
		Email.sendKeys(f.internet().emailAddress());
	}
	
	@FindBy(name = "company_title") private WebElement company_title;
	public void EnterCompanyTitle()  {
		wait.until(ExpectedConditions.visibilityOf(company_title)).clear();
		company_title.sendKeys(f.company().name());
		}
	
	@FindBy(xpath = "(//input[@type='text'])[1]") private WebElement phone_number;
	public void EnterPhoneNumber() throws InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(phone_number)).click();
	    JavascriptExecutor js = (JavascriptExecutor) Base_Class.driver;
	    js.executeScript("arguments[0].value='';", phone_number);
	    phone_number.sendKeys(f.phoneNumber().subscriberNumber(10));
	}
	
	@FindBy(name = "website") private WebElement Website;
	public void EnterWebsite()  {
		wait.until(ExpectedConditions.visibilityOf(Website)).clear();;
		Website.sendKeys("https://"+f.internet().url());
	}
	
	@FindBy(name = "company_address") private WebElement company_address;
	public void EnterCompanyAddress()  {
		wait.until(ExpectedConditions.visibilityOf(company_address)).clear();
		company_address.sendKeys(f.address().fullAddress());
	}
	
	@FindBy(xpath = "(//input[@type='text'])[2]") private WebElement pincode;
	public void EnterPincode() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(pincode)).click();
	    JavascriptExecutor js = (JavascriptExecutor) Base_Class.driver;
	    js.executeScript("arguments[0].value='';", pincode);
		pincode.sendKeys(f.address().zipCode());
	}
	
	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[2]") private WebElement CountryDropdown;
	public void ClickCountryDropdown()  {
		wait.until(ExpectedConditions.elementToBeClickable(CountryDropdown)).clear();
	}

	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[3]") private WebElement StateDropdown;
	public void ClickStateDropdown()  {
		wait.until(ExpectedConditions.elementToBeClickable(StateDropdown)).click();
	}
	
	@FindBy(xpath = "(//input[@aria-haspopup='listbox'])[4]") private WebElement CityDropdown;
	public void ClickCityDropdown()  {
		wait.until(ExpectedConditions.elementToBeClickable(CityDropdown)).click();
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
	
	@FindBy(xpath = "//span[contains(text(),'Save Changes')]") private WebElement SaveChanges;
	public void ClickSaveChanges() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(SaveChanges)).click();
	}
	
	public Update_Client_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
