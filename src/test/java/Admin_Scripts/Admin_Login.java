package Admin_Scripts;

import java.io.IOException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.Utility_Class;
import Scenarios.Login_Page;

public class Admin_Login extends Base_Class{
	ExtentTest test;
	@Test
	void Admin_Login_Test() throws InterruptedException, IOException {
		
		Login_Page pg= new Login_Page(driver);
	
		
		test = extent.createTest("Admin Login Test").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		 
		 
		 try {pg.Admin_Mail();
		 	test.pass(MarkupHelper.createLabel("Username Entered Successfully", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Username",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		
		
		 try {pg.EnterPWD();
		 	test.pass(MarkupHelper.createLabel("Password Entered Successfully", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Password",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		 
			
		 try {pg.ClickSignIn();
		 	test.pass(MarkupHelper.createLabel("Clicked on Signin", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Signin",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		 
			
		 Thread.sleep(1000);	
		 try {String currentUrl = Base_Class.driver.getCurrentUrl();
			if (!currentUrl.equals("https://qa-bidplan.aptagrim.co/dashboard")) {
		        Base_Class.driver.navigate().refresh();
		        Thread.sleep(1000);
		        pg.Admin_Mail();
		        pg.NewPwd();
		        pg.ClickSignIn();
		    }
			pg.URL_Validation();
		 	test.pass(MarkupHelper.createLabel("Navigated to Dashboad Successfully", ExtentColor.GREEN));
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); } 
		 catch (AssertionError e) {
			test.fail(MarkupHelper.createLabel("Failed to Navigate to Dashboad ",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
 				}
		
		 
	}
}
