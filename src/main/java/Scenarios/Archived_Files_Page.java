package Scenarios;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;


public class Archived_Files_Page {
	
	
	
	
	@FindBy(xpath = "(//div[@class='flex flex-col w-full '])[7]") private WebElement Archived_Files;
	public void Click_Archived_Files()  {
		Archived_Files.click();
    }
	
	@FindBy(xpath = "(//div/input)[13]") private WebElement Pagination;
	public void Pagination() {
		Pagination.click();
    }
	
	@FindBy(xpath = "//div[@value='100']") private WebElement Select100;
	public void Select100()  {
		Select100.click();
    }
	
	@FindBy(xpath = "//td[5]/div/div/span[2]") private List <WebElement> Lables;
	@FindBy(xpath = "//input[@type='checkbox']") private List <WebElement> Checkboxes;
		 
	public void UnArchive_File_Type(String Label) throws Exception {
	    boolean found = false;

	    for (int i = 0; i < Lables.size(); i++) {
	        String labelText = Lables.get(i).getText().trim();

	        if (labelText.equalsIgnoreCase(Label)) {
	            Thread.sleep(1000);
	            Checkboxes.get(i+1).click();  
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        throw new Exception();
	    }
	}
	
	
	@FindBy(xpath = "//span[contains(text(), 'Unarchive')]") private WebElement ClickArchive;
	public void ClickArchiveButton()  {
		ClickArchive.click();
    }
	
	@FindBy(xpath = "//span[contains(text(), 'Yes, Unarchive')]") private WebElement ConfirmArchive;
	public void ConfirmArchive()  {
		ConfirmArchive.click();
    }
	
	
	
	
	
	
	
	
	
	
	
	public Archived_Files_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
}
