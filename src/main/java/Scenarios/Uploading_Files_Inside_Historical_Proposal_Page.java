package Scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class Uploading_Files_Inside_Historical_Proposal_Page {
		
		@FindBy(xpath = "(//button[@aria-label=\"Menu\"])[1]") private WebElement menu_button;
		public void Menu_button() throws IOException {
	    menu_button.click();
	    }
	

	    @FindBy(xpath = "//div[text()='View']") private WebElement View_button;
	    public void view_button() throws IOException {
	    View_button.click();
	    }
	
	    
	    @FindBy(xpath = "(//button[@aria-label=\"Menu\"])[1]") private WebElement Received_Proposal_Menu_button;
	    public void Received_Propsoal_Menu_button() throws IOException {
	    	Received_Proposal_Menu_button.click();
	    }
	    
	    @FindBy(xpath = "//div[text()='View']") private WebElement Received_Proposal_View_button;
	    public void Received_Propsoal_view_button() throws IOException {
	    	Received_Proposal_View_button.click();
	    }  
	    
	    @FindBy(xpath = "//span[text()='Upload']") private WebElement Received_Proposal_Upload_button;
	    public void Received_Propsoal_Upload_button() throws IOException {
	    	Received_Proposal_Upload_button.click();
	    }  
	    
	    
	    @FindBy(xpath = "(//div[@role=\"presentation\"])[1]") private WebElement Received_Proposal_UploadFile_button ;
	    public void Received_Proposal_UploadFile_button() {
	    	Received_Proposal_UploadFile_button.click();
	    }
	    
	    @FindBy(xpath = "(//span[text()='Upload'])[2]") private WebElement Received_Proposal_Final_Upload_button ;
	    public void Received_Proposal_Final_Upload_button() {
	    	Received_Proposal_Final_Upload_button.click();
	    }
	    
	    @FindBy(xpath = "(//a[@data-underline=\"hover\"])[2]") private WebElement BreadCrumbs;
	    public void Breadcrumbs() {
	    	BreadCrumbs.click();
	    }
	    
	    @FindBy(xpath = "(//button[@aria-haspopup=\"menu\"])[2]") private WebElement Submitted_Proposal_Menu_button;
	    public void Submitted_Propsoal_Menu_button() throws IOException {
	    	Submitted_Proposal_Menu_button.click();
	    }
	    
	    @FindBy(xpath = "//div[text()='View']") private WebElement Submitted_Proposal_View_button;
	    public void Submitted_Propsoal_view_button() throws IOException {
	    	Submitted_Proposal_View_button.click();
	    } 
	    
	    @FindBy(xpath = "(//button[@aria-label=\"Menu\"])[3]") private WebElement Supporting_Document_Menu_button;
	    public void Supporting_Document_Menu_button() throws IOException {
	    	Supporting_Document_Menu_button.click();
	    }
	    
	    @FindBy(xpath = "//div[text()='View']") private WebElement Supporting_Document_View_button;
	    public void Supporting_Document_view_button() throws IOException {
	    	Supporting_Document_View_button.click();
	    } 
	    
	   
	    
	    public Uploading_Files_Inside_Historical_Proposal_Page(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
}
