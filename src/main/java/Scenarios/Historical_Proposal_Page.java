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


public class Historical_Proposal_Page {

	
	
	@FindBy(xpath = "(//div[@class=\"flex flex-col w-full \"])[2]") private WebElement Historica_proposal;
	public void Hisotical_proposal() throws IOException {
    Historica_proposal.click();
    }
	
	@FindBy(xpath = "(//span[text()='Upload'])[2]") private WebElement Upload_button;
	public void Upload_button() throws IOException {
    Upload_button.click();
    }
	
	@FindBy(xpath = "//input[@name=\"title\"]") private WebElement title;
	public void title() throws IOException {
		title.sendKeys(Utility_Class.getCellData("Historical Proposal", 4, 2));
	}
	
	@FindBy(xpath = "//input[@name=\"client\"]") private WebElement client;
	public void client() throws IOException {
		client.sendKeys(Utility_Class.getCellData("Historical Proposal", 4, 3));
	}
	
	@FindBy(xpath = "//input[@placeholder=\"Select\"]") private WebElement bidstatus_dropdown;
	public void bidstatus_dropdown() {
		bidstatus_dropdown.click();
	}
	
	@FindBy(xpath = "//div[@value=\"7\"]") private WebElement bidstatus;
	public void bidstatus() {
		bidstatus.click();
	}
	
	@FindBy(xpath = "//input[@type=\"text\"]") private WebElement tags;
	public void tags() throws IOException {
		tags.sendKeys(Utility_Class.getCellData("Historical Proposal", 4, 4));
		
	}
	
	@FindBy(xpath = "(//div[@role=\"presentation\"])[1]") private WebElement received_proposal;
	public void received_proposal() {
		received_proposal.click();
	}
	@FindBy(xpath = "(//div[@role=\"presentation\"])[2]") private WebElement submitted_proposal;
	public void submitted_proposal() {
		submitted_proposal.click();
	}
	@FindBy(xpath = "(//div[@role=\"presentation\"])[3]") private WebElement supporting_documents;
	public void supporting_documents() {
		supporting_documents.click();
	}
	
	@FindBy(xpath = "(//span[text()='Upload'])[3]") private WebElement upload_proposal;
	public void upload_proposal() {
		upload_proposal.click();
	}
	
	WebDriverWait wait = new WebDriverWait(Base_Class.driver, Duration.ofSeconds(20));
	public void Title_Validation() {
	    wait.until(ExpectedConditions.visibilityOf(title));
	}
	public Historical_Proposal_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
