package Base_Package;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Base_Class {
	
	public static ExtentReports extent;
	ExtentSparkReporter sparkReporter;  
	public WebDriver driver;
	public static  String userdir = System.getProperty("user.dir");
//======================================={Browser Initialization}===============================================
	
	@BeforeSuite
	public void generateReport() throws IOException{
		sparkReporter =new ExtentSparkReporter("Reports/Automation_Report.html");
		sparkReporter.loadXMLConfig(new File(userdir + "/extentconfig.xml"));
		extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);	
	    extent.setSystemInfo("Project_Name", "Test Project");
	    extent.setSystemInfo("Environment", "LOCAl");}
	


		@BeforeClass
	@Parameters({"Browser_Name", "url"})
	public void setUp() {
	   ChromeOptions options = new ChromeOptions();
		    String userDataDir = System.getProperty("user.dir") + "/chrome_user_data_" + System.currentTimeMillis();

	     options.addArguments("user-data-dir=" + userDataDir);
	     driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        }
	
	
//	@BeforeClass
//		@Parameters({"Browser_Name", "url"})
//		public void setUp() {
//		driver = new ChromeDriver();
//		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		        driver.manage().window().maximize();
//		        driver.get("https://practicetestautomation.com/practice-test-login/");
//		}
//	
	
		
		@AfterSuite
		public void Close_Browser() throws IOException {
			extent.flush();
			driver.quit();
			Desktop.getDesktop().browse(new File(userdir + "/Reports/Automation_Report.html").toURI());

			
		}
		
		
		



}
