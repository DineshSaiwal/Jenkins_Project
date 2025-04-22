package Test_Package;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base_Package.Base_Class;
import Base_Package.Login_Page;

public class Login extends Base_Class{
	ExtentTest test;
	
	@Test
	void Test_Login() throws InterruptedException {
		
		Login_Page pg=new Login_Page( driver);
		test = extent.createTest("This is a test project").assignAuthor("Dinesh_Saiwal").assignCategory("Regression");
		
		Thread.sleep(1000);
		pg.EnterUN();
		test.pass(MarkupHelper.createLabel("Entered UN", ExtentColor.GREEN));
		Thread.sleep(1000);
		pg.Password();
		test.pass(MarkupHelper.createLabel("Entered PWD", ExtentColor.GREEN));	}

	
	
}
