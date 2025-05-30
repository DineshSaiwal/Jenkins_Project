package Bid_Manager_Scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Permission.Permission;
import Scenarios.Updating_BidManager_Page;

public class Updating_BidManager extends Base_Class {

ExtentTest test;
	
	@Test
	void Update_Bid_Manager_Test() throws Exception{
		
		
		
		Updating_BidManager_Page pg = new Updating_BidManager_Page(driver);
		test = extent.createTest("Update Bid Manager Test").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		 
		User_Login.Bid_Manager();
		
		Permission p= new Permission();
		 if (!p.User_Permission_Check("Settings", "User Management")) {
		        test.skip(MarkupHelper.createLabel("⛔ Skipping test: Logged-in user does not have permission for the User Management", ExtentColor.BLACK));
		        return; 
		    } else {
		        test.pass(MarkupHelper.createLabel("✅ The Logged-in User Has Permission For The User Management", ExtentColor.BLACK));
		    }
		
		 Thread.sleep(2000);
		 try {pg.NavigateToUserManagement();
		 	test.pass(MarkupHelper.createLabel("Navigated to the User Management Page", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Navigate User Management",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {pg.GetStatus("Bid Manager");
		 	test.pass(MarkupHelper.createLabel("Checking Status", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Add User Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.UpdateUserName();
		 	test.pass(MarkupHelper.createLabel("Entered Username", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter UserName",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.UpdateEmail();
		 	test.pass(MarkupHelper.createLabel("Entered Email", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Enter Email",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.ClickRole();
		 	test.pass(MarkupHelper.createLabel("Clicked on Role", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on Role",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.SelectRole("Team Member");
		 	test.pass(MarkupHelper.createLabel("Selected Role as Bid Manager", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select Role as Bid Manager",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.SaveChanges();
		 	test.pass(MarkupHelper.createLabel("Clicked on Add Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on Add Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {Utility_Class.Toast_Message_Validation("User Updated The user details have been updated successfully.");
		 	test.pass(MarkupHelper.createLabel("User Updated The user details have been updated successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Update The User!", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); }
		
}
}