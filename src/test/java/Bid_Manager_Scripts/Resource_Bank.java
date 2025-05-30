package Bid_Manager_Scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Scenarios.Historical_Proposal_Page;
import Scenarios.Login_Page;
import Scenarios.Resource_Bank_Page;


public class Resource_Bank extends Base_Class {
ExtentTest test;
	

	@Test
	void Adding_Historical_Proposal() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		Resource_Bank_Page rb = new Resource_Bank_Page(driver);
		
		User_Login.Bid_Manager();
		test = extent.createTest("Resource").assignAuthor("Abhishek Mekala").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		
      	Thread.sleep(1000);
		 try {rb.Resoruce_bank();
		 	test.pass(MarkupHelper.createLabel("Clicked on Resoruce Bank button on side bar", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Resoruce Bank button on side bar",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		 Thread.sleep(1000);
		 try {rb.upload();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Upload button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {rb.Document_Details();
		 	test.pass(MarkupHelper.createLabel("Entered Document Details", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Document Details",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		  
		 Thread.sleep(1000);
		 try {rb.Tags();
		 	test.pass(MarkupHelper.createLabel("Entered Tag", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Tag",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//input[@placeholder=\"e.g. Company, Details\"]")).sendKeys(Keys.ENTER);
		 
		  
		 Thread.sleep(1000);
		
		 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Keys.ESCAPE);
		 
		  
		  Thread.sleep(1000);
		  try {rb.Upload_File();
		  StringSelection stringSelection = new StringSelection(Received_Document);
		 	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	      
		 	//Robot class to perform actions on file upload popup
		 	 Robot r=new Robot();
		 	 r.delay(2000);
		     r.keyPress(KeyEvent.VK_CONTROL);
		     r.keyPress(KeyEvent.VK_V);
		     r.keyRelease(KeyEvent.VK_CONTROL);
		     r.keyRelease(KeyEvent.VK_V);
		     r.keyPress(KeyEvent.VK_ENTER);
		     r.keyRelease(KeyEvent.VK_ENTER);
		     r.delay(1500);
		 	test.pass(MarkupHelper.createLabel("Uploaded Document", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload Document",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		  Thread.sleep(1000);
		  try {rb.Upload_Button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload Button", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Upload Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		
		  try {
			  rb.Document_Detail_Validation();
		 	test.pass(MarkupHelper.createLabel("Document Uplaoded in Resoruce Bank Successfully", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload Document in Resoruce Bank",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
}}
