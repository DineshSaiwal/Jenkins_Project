package Super_Admin_Scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Base_Package.Base_Class;
import Base_Package.User_Login;
import Base_Package.Utility_Class;
import Permission.Permission;
import Scenarios.Inactive_Client_Page;
 
public class Inactive_Client extends Base_Class{

	ExtentTest test;
	
	@Test
	public void Inactivate_Client_Test() throws Exception {
		Inactive_Client_Page pg = new Inactive_Client_Page(driver);
		test = extent.createTest("Inactive The Active Client").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
		test.info(MarkupHelper.createLabel("Test Case Executed On { "+ browserName +" } Browser", ExtentColor.BLUE));
		 
		User_Login.SuperAdmin();
		
		Permission p= new Permission();
		  p.SessionFetch();
		 if (!p.Is_Super_Admin) {
		        test.skip(MarkupHelper.createLabel("⛔ Skipping test: Logged-in user is not a Super Admin", ExtentColor.ORANGE));
		        return; 
		    } else {
		        test.pass(MarkupHelper.createLabel("✅ The Logged-in User is a Super Admin", ExtentColor.BLACK));
		    }
		    	
		 
		 Thread.sleep(1000);
		 try {pg.NavigateToClientmanagement();
		 	test.pass(MarkupHelper.createLabel("Navigated to the Client Management Page", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to navigate Client Management",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}

		 try {pg.GetStatus("Active");
		 	test.pass(MarkupHelper.createLabel("Checking Active Client", ExtentColor.GREEN));
		 	test.pass(MarkupHelper.createLabel("Found Active Client", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Check Active Client",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 try {pg.ClickInactive();
		 	test.pass(MarkupHelper.createLabel("Clicked on InActive Option", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Inactive Option",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}

		 try {pg.Confirm();
		 	test.pass(MarkupHelper.createLabel("Clicked on Confirm Inactive", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Confirm Inactive",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}

		 try {Utility_Class.Toast_Message_Validation("Client Status Updated The client has been successfully marked as inactive.");
		 	test.pass(MarkupHelper.createLabel("Client Status Updated The client has been successfully marked as inactive.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Inactivate The Client", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); 	}
	  	
	
}
	
}
