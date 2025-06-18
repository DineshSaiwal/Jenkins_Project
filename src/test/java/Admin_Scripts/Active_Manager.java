package Admin_Scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Permission.Permission;
import Scenarios.User_Active_Inactive;

public class Active_Manager extends Base_Class{
	
	ExtentTest test;

	@Test
	public void Active_Inavtive_Manager() throws Exception {

		User_Active_Inactive pg = new User_Active_Inactive(driver);
		test = extent.createTest("Active The InActive Manager").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));

		User_Login.Admin();
	
		Permission p= new Permission();
		  p.SessionFetch();
		 if (!p.Is_Admin) {
		        test.skip(MarkupHelper.createLabel("⛔ Skipping test: Logged-in user is not a Admin", ExtentColor.ORANGE));
		        return; 
		    } else {
		        test.pass(MarkupHelper.createLabel("✅ The Logged-in User is a Admin", ExtentColor.BLACK));
		    }
		 
		Thread.sleep(1000);
		 try {pg.NavigateToClientmanagement();
		 	test.pass(MarkupHelper.createLabel("Navigated to the Client Management Page", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to navigate Client Management",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.GetStatus("Bid Manager", "Inactive" );
		 	test.pass(MarkupHelper.createLabel("Active Bid Manager Were Found", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Did Not Found Active Bid Manager",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		
		 try {pg.ClickConfirm();
		 	test.pass(MarkupHelper.createLabel("Clicked on Confirm", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Confirm",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		
		 
		 try {Utility_Class.Toast_Message_Validation("User Status Updated The users have been successfully marked as active.");
		 	test.pass(MarkupHelper.createLabel("User Status Updated The users have been successfully marked as active.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Make The User As Active", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); }
		  	
	
		}
	
}