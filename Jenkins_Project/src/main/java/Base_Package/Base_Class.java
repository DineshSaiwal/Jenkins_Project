package Base_Package;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
public class Base_Class {
	

	public WebDriver driver;
	
//======================================={Browser Initialization}===============================================
	
	@BeforeClass
		@Parameters({"Browser_Name", "url"})
		public void setUp() {
		   
		    
		driver = new ChromeDriver();
		    

		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.manage().window().maximize();
		        driver.get("https://practicetestautomation.com/practice-test-login/");
		
		}
	
	
	
		
		@AfterClass
		public void Close_Browser() {
			driver.quit();
			
		}
		
		
		



}
