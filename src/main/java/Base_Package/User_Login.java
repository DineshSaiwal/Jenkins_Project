package Base_Package;

import java.io.IOException;
import Scenarios.Login_Page;

public class User_Login {

	
	
	
	public static final void SuperAdmin() throws IOException, InterruptedException {
		Login_Page pg= new Login_Page(Base_Class.driver);
		pg.Super_Admin_Mail();
		pg.EnterPWD();
		pg.ClickSignIn();
	}
	
	public static final void Admin() throws IOException, InterruptedException {
		Login_Page pg= new Login_Page(Base_Class.driver);
		pg.Admin_Mail();
		pg.EnterPWD();
		pg.ClickSignIn();
	}
	
	public static final void Bid_Manager() throws IOException, InterruptedException {
		Login_Page pg= new Login_Page(Base_Class.driver);
		pg.Bid_Manager_mail();
		pg.EnterPWD();
		pg.ClickSignIn();
	}
	public static final void Team_Member() throws IOException, InterruptedException {
		Login_Page pg= new Login_Page(Base_Class.driver);
		pg.Team_Member_mail();
		pg.EnterPWD();
		pg.ClickSignIn();
	}
}
