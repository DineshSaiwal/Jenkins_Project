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
import Scenarios.Add_Client_Page;
 
public class Add_Client extends Base_Class{

ExtentTest test;
	
	@Test
	void Add_Client_Test() throws Exception {
		
		Add_Client_Page pg = new Add_Client_Page(driver);
		test = extent.createTest("Add Client Test").assignAuthor("Dinesh_Saiwal").assignDevice(browserName).assignCategory("Smoke");
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
 
		 Thread.sleep(2000);
		 try {pg.NavigateToClientmanagement();
		 	test.pass(MarkupHelper.createLabel("Navigated to the Client Management Page", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to navigate Client Management",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {pg.ClickOnAddNewClient();
		 	test.pass(MarkupHelper.createLabel("Clicked on Add Client Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Add Client Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		
		 try {pg.UploadFile();
		 	test.pass(MarkupHelper.createLabel("Uploaded Company Logo", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Upload Company Logo",  ExtentColor.RED));
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
		
		 try {pg.EnterCompanyTitle();
		 	test.pass(MarkupHelper.createLabel("Entered Company Title", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Enter Company Title",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.EnterPhoneNumber();
		 	test.pass(MarkupHelper.createLabel("Entered Phone Number", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Enter Phone Number",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.EnterWebsite();
		 	test.pass(MarkupHelper.createLabel("Entered Website URL", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Enter Website URL",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
	
		 try {pg.EnterCompanyAddress();
		 	test.pass(MarkupHelper.createLabel("Entered Company Address", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Enter Company Address",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.ClickCountryCode();
		 	test.pass(MarkupHelper.createLabel("Clicked On Country Code Dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on County Code Dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 try {pg.SelectOption("+91 IN");
		 	test.pass(MarkupHelper.createLabel("Selected the County Code", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select Country Code",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.ClickCountryDropdown();
		 	test.pass(MarkupHelper.createLabel("Clicked On Country Dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on County Dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 try {pg.SelectOption("India");
		 	test.pass(MarkupHelper.createLabel("Selected the County", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select Country",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 try {pg.ClickStateDropdown();
		 	test.pass(MarkupHelper.createLabel("Clicked On State Dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on State Dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 try {pg.SelectOption("Maharashtra");
		 	test.pass(MarkupHelper.createLabel("Selected the State", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select State",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 

		 try {pg.ClickCityDropdown();
		 	test.pass(MarkupHelper.createLabel("Clicked On State Dropdown", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Click on State Dropdown",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 
		 try {pg.SelectOption("Pune");
		 	test.pass(MarkupHelper.createLabel("Selected the State", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed To Select State",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 try {pg.EnterPincode();
		 	test.pass(MarkupHelper.createLabel("Entered Pincode", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Enter Pincode",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		
		 try {pg.ClickAddClient();
		 	test.pass(MarkupHelper.createLabel("Clicked on Add Client Button", ExtentColor.GREEN));} 
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Click on Add Client Button",  ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Exception occurred ==> " + e.getMessage());
				}
		 
		 Thread.sleep(1000);
		 try {Utility_Class.Toast_Message_Validation("Client Added The new client has been added successfully.");
		 	test.pass(MarkupHelper.createLabel("Client Added The new client has been added successfully.", ExtentColor.GREEN)); 
		 	test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); }
		 catch (Exception e) {
			test.fail(MarkupHelper.createLabel("Failed to Add New Client!", ExtentColor.RED));
			test.addScreenCaptureFromBase64String(Utility_Class.Capture_Screenshot()); 
			test.log(Status.FAIL, "Got an Error Message : "+Utility_Class.Actual_Message); }
		  	
	}
	
	
	
}
