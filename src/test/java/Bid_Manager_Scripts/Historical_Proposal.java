package Bid_Manager_Scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Scenarios.Historical_Proposal_Page;


public class Historical_Proposal extends Base_Class {
ExtentTest test;
	

	@Test
	void Adding_Historical_Proposal() throws InterruptedException, IOException {
		
		
		
		 
		Thread.sleep(2000);
		Historical_Proposal_Page hp= new Historical_Proposal_Page(driver);
		
		
		User_Login.Bid_Manager();
		test = extent.createTest("Historical Proposal").assignAuthor("Abhishek Mekala").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		
      	Thread.sleep(1000);
		 try {hp.Hisotical_proposal();
		 	test.pass(MarkupHelper.createLabel("Clicked on Historical Proposal button on side bar", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Historical Proposal button on side bar",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		 Thread.sleep(1000);
		 try {hp.Upload_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Upload button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {hp.title();
		 	test.pass(MarkupHelper.createLabel("Entered Title", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter title",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {hp.client();
		 	test.pass(MarkupHelper.createLabel("Entered Client Name", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Client Name",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {hp.bidstatus_dropdown();
		 	test.pass(MarkupHelper.createLabel("Clicked on bid status dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to click on Bidstatus dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(2000);
		 try {
			 hp.bidstatus();
		 	test.pass(MarkupHelper.createLabel("Clicked on Bid status", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Clicked on Bid status",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {hp.tags();
		 	test.pass(MarkupHelper.createLabel("Entered Tag", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Tag",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//input[@placeholder=\"e.g  Marketing, Web Design\"]")).sendKeys(Keys.ENTER);
		 
		  
		 Thread.sleep(1000);
		
		 driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Keys.ESCAPE);
		 
		  
		  Thread.sleep(1000);
		  try {hp.received_proposal();
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
		 	test.pass(MarkupHelper.createLabel("Uploaded Received Document", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload Received Document",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		  Thread.sleep(1000);
		  try {hp.submitted_proposal();
		  StringSelection stringSelection = new StringSelection(Submitted_Document);
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
		 	test.pass(MarkupHelper.createLabel("Uploaded Submitted Document", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Submitted Received Document",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		  Thread.sleep(1000);
		  try {hp.supporting_documents();
		  StringSelection stringSelection = new StringSelection(Supported_Document);
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
		 	test.pass(MarkupHelper.createLabel("Uploaded Supporting Document", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Supporting Received Document",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		  Thread.sleep(1000);
		  try {hp.upload_proposal();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload Proposal Button", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Upload Proposal Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		
		  try {
			  hp.Title_Validation();
		 	test.pass(MarkupHelper.createLabel("Historical Proposal Uploaded Successfully", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload historical document",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
}}
