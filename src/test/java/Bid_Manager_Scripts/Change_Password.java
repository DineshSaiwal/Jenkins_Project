package Bid_Manager_Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Scenarios.Change_Password_Page;


public class Change_Password extends Base_Class{
ExtentTest test;
String pass1 = "Abcd.1234";
String pass2 = "Abcd.12345";

	@Test
	void Bid_Manager_Change_Password() throws Exception {
		Change_Password_Page pg = new Change_Password_Page(driver);
		test = extent.createTest("Bid Manager Change Password").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		
		User_Login.Bid_Manager();
		
		Thread.sleep(2000);
		 try {pg.ClickOnProfileIcon();
		 	test.pass(MarkupHelper.createLabel("Clicked On profile Icon", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to click on profile Icon",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		 
		 try {pg.ClickMyProfile();
		 	test.pass(MarkupHelper.createLabel("Clicked On My Profile", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click On My Profile",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.ClickUpdatePassword();
		 	test.pass(MarkupHelper.createLabel("Clicked On Update Password", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to click Update Password",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {
	            pg.Enter_Old_Password(pass1);
	            test.pass(MarkupHelper.createLabel("Entered Old Password: " + pass1, ExtentColor.GREEN));
	            
	            pg.Confirm_Password(pass2);
	            test.pass(MarkupHelper.createLabel("Confirmed Password: " + pass2, ExtentColor.GREEN));

	            pg.Enter_New_Password(pass2);
	            test.pass(MarkupHelper.createLabel("Entered New Password: " + pass2, ExtentColor.GREEN));

	            pg.ClickOnSaveChange();
	            test.pass(MarkupHelper.createLabel("Clicked On Save Change Button", ExtentColor.GREEN));
	            Thread.sleep(1000);
	            WebElement message = driver.findElement(By.xpath("//div[@role='alert']"));
	            String actualMessage = message.getText().replace("\n"," ").trim();

	            if (actualMessage.equals("Password Updated Successfully Your password has been updated successfully.")) {
	                test.pass(MarkupHelper.createLabel(actualMessage, ExtentColor.GREEN));
	                test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot());
	            } else if (actualMessage.equals("Password Validation Failed Old Password is incorrect.")) {
	                test.pass("Old password incorrect. Retrying with reversed values...");
	                
	                driver.navigate().refresh();
	                Thread.sleep(2000);
	                pg.ClickUpdatePassword();
	                pg.Enter_Old_Password(pass2);
		            test.pass(MarkupHelper.createLabel("Entered Old Password: " + pass2, ExtentColor.GREEN));
		            
		            pg.Enter_New_Password(pass1);
		            test.pass(MarkupHelper.createLabel("Entered New Password: " + pass1, ExtentColor.GREEN));

		            pg.Confirm_Password(pass1);
		            test.pass(MarkupHelper.createLabel("Confirmed Password: " + pass1, ExtentColor.GREEN));
		            
	                pg.ClickOnSaveChange();
	                test.pass(MarkupHelper.createLabel("Clicked On Save Change Button", ExtentColor.GREEN));
	                Thread.sleep(1000);
	                WebElement retryElement = driver.findElement(By.xpath("//div[@role='alert']"));
	                String retryMessage = retryElement.getText().replace("\n"," ").trim();

	                if (retryMessage.equals("Password Updated Successfully Your password has been updated successfully.")) {
	                    test.pass(MarkupHelper.createLabel(retryMessage, ExtentColor.GREEN));
	                    test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot());
	                } else {
	                    test.fail(MarkupHelper.createLabel("Password change failed. Message: " + retryMessage, ExtentColor.RED));
	                }
	            } else {
	                test.fail(MarkupHelper.createLabel("Unexpected toast message: " + actualMessage, ExtentColor.RED));
	            }

	        } catch (Exception e) {
	            test.fail(MarkupHelper.createLabel("Failed to update password", ExtentColor.RED));
	            test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot());
	            test.log(Status.FAIL, "Exception occurred: " + e.getMessage());
	        }
	    }

	
		 
	 
	 
		 
		 
		   
	}

 
