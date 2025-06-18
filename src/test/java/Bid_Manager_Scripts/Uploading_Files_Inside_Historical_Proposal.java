package Bid_Manager_Scripts;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Scenarios.Historical_Proposal_Page;
import Scenarios.Uploading_Files_Inside_Historical_Proposal_Page;

public class Uploading_Files_Inside_Historical_Proposal extends Base_Class {

ExtentTest test;
	

	@Test
	void Uploading_Files_Inside_Historical_Proposal() throws InterruptedException, IOException {
		
		
		User_Login.Bid_Manager();
		 
		Thread.sleep(2000);
		Historical_Proposal_Page hp= new Historical_Proposal_Page(driver);
		
		Uploading_Files_Inside_Historical_Proposal_Page uhp = new Uploading_Files_Inside_Historical_Proposal_Page(driver);
		
		test = extent.createTest("Uploading_Files_Inside_Historical_Proposal").assignAuthor("Abhishek Mekala").assignDevice(browserName).assignCategory("Smoke");
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
		 
		 try {uhp.Menu_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Menu Button on the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Menu Button on the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 try {uhp.view_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on View Button on the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on View Button on the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Propsoal_Menu_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Received Proposal Menu Button on the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Received Proposal Menu Button on the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
	
		 try {uhp.Received_Propsoal_view_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Received Proposal view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Received Proposal view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Propsoal_Upload_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Received Proposal view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Received Proposal view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		  try {uhp.Received_Proposal_UploadFile_button();
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
		 	test.pass(MarkupHelper.createLabel("Uploaded Received Document inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload Received Document inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Proposal_Final_Upload_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload button after uplaoding a received document file", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click  on Upload button after uplaoding a received document file",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
	/*	 try {Utility_Class.Toast_Message_Validation("The document has been uploaded successfully.");
		 	test.pass(MarkupHelper.createLabel("The document has been uploaded successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload the Document", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); } */
		 
		 
		 //Submitted Proposal
		 
		 try {uhp.Breadcrumbs();
		 	test.pass(MarkupHelper.createLabel("Clicked on Breadcrumbs to go back and upload file in submitted Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Breadcrumbs to go back and upload file in submitted Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 Thread.sleep(1000);
		 try {uhp.Submitted_Propsoal_Menu_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on submitted Proposal Menu Button on the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on submitted Proposal Menu Button on the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
	
		 try {uhp.Submitted_Propsoal_view_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on submitted Proposal view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on submitted Proposal view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
Thread.sleep(1000);
		 
		 try {uhp.Received_Propsoal_Upload_button(); //same xpath is used as for received proposal for submitted proposal
		 	test.pass(MarkupHelper.createLabel("Clicked on submitted Proposal view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on submitted Proposal view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		  try {uhp.Received_Proposal_UploadFile_button();
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
		 	test.pass(MarkupHelper.createLabel("Uploaded submitted Document inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload submitted Document inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Proposal_Final_Upload_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload button after uplaoding a submitted document file", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click  on Upload button after uplaoding a submitted document file",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		/* try {
			 WebElement toastMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'The document has been uploaded successfully.')]")));

		 	test.pass(MarkupHelper.createLabel("The document has been uploaded successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload the Document", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); 
			} */
		 Thread.sleep(1000);
		 try {uhp.Breadcrumbs();
		 	test.pass(MarkupHelper.createLabel("Clicked on Breadcrumbs to go back and upload file in supporting documents", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Breadcrumbs to go back and upload file in supporting documents ",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 //Supporting Documents
		 
		 Thread.sleep(3000);
		 try {uhp.Supporting_Document_Menu_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on supporting Document Menu Button on the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on supporting Document Menu Button on the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
	
		 try {uhp.Supporting_Document_view_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on supporting Document view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on supporting Document view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Propsoal_Upload_button(); //same xpath is used as for received proposal for supporting Document
		 	test.pass(MarkupHelper.createLabel("Clicked on supporting Document view Button inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on supporting Document view Button inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 Thread.sleep(1000);
		 
		  try {uhp.Received_Proposal_UploadFile_button();
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
		 	test.pass(MarkupHelper.createLabel("Uploaded supporting Document inside the uploaded Historical Proposal", ExtentColor.GREEN));} 
		    catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload supporting Document inside the uploaded Historical Proposal",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}	
		  
		 Thread.sleep(1000);
		 
		 try {uhp.Received_Proposal_Final_Upload_button();
		 	test.pass(MarkupHelper.createLabel("Clicked on Upload button after uplaoding a supporting Document file", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click  on Upload button after uplaoding a supporting Document file",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
	
		 
		/* try {Utility_Class.Toast_Message_Validation("The document has been uploaded successfully.");
		 	test.pass(MarkupHelper.createLabel("The document has been uploaded successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload the Document", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); 
		 }
	*/
		
}
}