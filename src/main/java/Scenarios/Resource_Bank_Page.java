package Scenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_Package.Base_Class;
import Base_Package.Utility_Class;

public class Resource_Bank_Page {
	@FindBy(xpath = "(//div[@class=\"flex flex-col w-full \"])[5]") private WebElement Resource_Bank;
	public void Resoruce_bank() throws IOException {
    Resource_Bank.click();
    }
	
	@FindBy(xpath = "//span[text()='Upload']") private WebElement Upload;
	public void upload() throws IOException {
    Upload.click();
    }
	
	@FindBy(xpath = "//input[@name=\"description\"]") private WebElement Document_Details;
	public void Document_Details() throws IOException {
    Document_Details.sendKeys(Utility_Class.getCellData("Historical Proposal", 4, 2));
    }
	
	@FindBy(xpath = "//input[@type=\"text\"]") private WebElement Tags;
	public void Tags() throws IOException {
    Tags.sendKeys(Utility_Class.getCellData("Historical Proposal", 4, 4));
    }
	
	@FindBy(xpath = "(//div[@role=\"presentation\"])[1]") private WebElement Upload_File;
	public void Upload_File() {
		Upload_File.click();
	}
	
	@FindBy(xpath = "(//span[text()='Upload'])[2]") private WebElement Upload_Button;
	public void Upload_Button() {
		Upload_Button.click();
	}
	
	WebDriverWait wait = new WebDriverWait(Base_Class.driver, Duration.ofSeconds(20));
	public void Document_Detail_Validation() {
	    wait.until(ExpectedConditions.visibilityOf(Document_Details));
	}
	
	public Resource_Bank_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
}
