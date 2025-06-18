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
import Scenarios.Archived_Files_Page;

public class UnArchive_Proposal_Bank_File extends Base_Class{
	
	ExtentTest test;

	@Test
	public void Unarchive_Proposal_Bank_File() throws Exception {

		Archived_Files_Page pg = new Archived_Files_Page(driver);
		test = extent.createTest("UnArchive Proposal Bank File").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
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
		 
 		 try {pg.Click_Archived_Files();
		 	test.pass(MarkupHelper.createLabel("Navigated to Archive File Section", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Navigate Archive File Section",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
 		 try {pg.Pagination();
		 	test.pass(MarkupHelper.createLabel("Clicked On Pagination Dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click On Pagination Dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
 		 try {pg.Select100();
		 	test.pass(MarkupHelper.createLabel("Selected Pagination as 100", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Select Pagination as 100",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
 		 try {pg.UnArchive_File_Type("Proposal Bank File");
		 	test.pass(MarkupHelper.createLabel("Found the Proposal Bank File To Unarchive", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.skip(MarkupHelper.createLabel("⛔ Skipping test: No Proposal Bank Found File To UnArchive", ExtentColor.ORANGE));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			return; 
				}
		 
 		 try {pg.ClickArchiveButton();
		 	test.pass(MarkupHelper.createLabel("Click On UnArchive Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click On UnArchive Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
 		 try {pg.ConfirmArchive();
		 	test.pass(MarkupHelper.createLabel("Clicked On Confirm UnArchive ", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click On Confirm UnArchive",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {Utility_Class.Toast_Message_Validation("Back to Its Place The file has been placed back in its original location.");
		 	test.pass(MarkupHelper.createLabel("Back to Its Place The file has been placed back in its original location.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to UnArchive The File!", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); }
		 
		}
	}
