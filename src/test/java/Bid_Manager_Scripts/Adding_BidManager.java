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
import Scenarios.Adding_User;

public class Adding_BidManager extends Base_Class {

ExtentTest test;
	
	@Test
	void Add_Bid_Manager_Test() throws Exception{
		
		Adding_User pg = new Adding_User(driver);
		test = extent.createTest("Add Bid Manager Test").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
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
		 try {pg.NavigateToClientmanagement();
		 	test.pass(MarkupHelper.createLabel("Navigated to the User Management Page", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Navigate User Management",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {pg.AddUser();
		 	test.pass(MarkupHelper.createLabel("Clicked on Add User Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Add User Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.EnterUserName();
		 	test.pass(MarkupHelper.createLabel("Entered Username", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter UserName",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.EnterEmail();
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
		 
		 try {pg.SelectRole("Bid Manager");
		 	test.pass(MarkupHelper.createLabel("Selected Role as Bid Manager", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select Role as Bid Manager",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.ClickAddButton();
		 	test.pass(MarkupHelper.createLabel("Clicked on Add Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on Add Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {Utility_Class.Toast_Message_Validation("User Added The new user has been added successfully.");
		 	test.pass(MarkupHelper.createLabel("User Added The new user has been added successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Add New User!", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); }
		  	
}
}