package Test_Package;

import org.testng.annotations.Test;
import Base_Package.Base_Class;
import Base_Package.Login_Page;

public class Login extends Base_Class{

	@Test
	void Test_Login() throws InterruptedException {
		
		Login_Page pg=new Login_Page( driver);
		
	pg.EnterUN();
	System.out.println("User Name Entered Successfully");
	Thread.sleep(2000);
	pg.Password();
	System.out.println("Password Entered Successfully");
	}

	
	
}
