package Base_Package;
import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.ReportStats;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Class {
	
		public static ExtentReports extent;
		ExtentSparkReporter sparkReporter;  
		public static WebDriver driver;
		public static String userdir = System.getProperty("user.dir");
		public static String  browserName;
		public static String Pass;
		public static String P_Percentage;
		public static String Fail;
		public static String F_Percentage;
			
		public static String T_Pass;
		public static String P_Scrips;
		public static String T_Fail;
		public static String F_Scripts;
		public static String result;
		
		@BeforeSuite
		public void generateReport() throws IOException{
			
			String timestamp = new SimpleDateFormat("dd-MM-yy_HH-mm-ss").format(new Date());
			String reportPath = "Reports/Automation_Report_" + timestamp + ".html";
			sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.loadXMLConfig(new File(userdir + "/extentconfig.xml"));
			extent = new ExtentReports();
		    extent.attachReporter(sparkReporter);	
		    extent.setSystemInfo("Project_Name", "bidPlan");
		    extent.setSystemInfo("Environment", "QA");
		}
		
		
		@BeforeClass 
		@Parameters({"url"})
		public void setUp(String url) throws IOException{
		    ChromeOptions options = new ChromeOptions();
		    String userDataDir = userdir + "/chrome_user_data_" + System.currentTimeMillis();
		    Files.createDirectories(Paths.get(userDataDir));   
			
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("user-data-dir=" + userDataDir); 
			
		    driver = new ChromeDriver(options);
		    browserName = ((ChromeDriver) driver).getCapabilities().getBrowserName();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.manage().window().maximize();
		    driver.get(url);
		}
			
		
		@AfterTest
		public void Execution_Results() {

			ReportStats Stats = extent.getStats();	    
		    Map<Status, Float> Parent_percentage = Stats.getParentPercentage();
		    
		    for (Map.Entry<Status, Float> details : Parent_percentage.entrySet()) {
		  	  	Status key = details.getKey();
		          Float value = details.getValue();
		          if (key.equals(Status.PASS)) {
		          		Pass=key.toString();
		          		P_Percentage=value.toString();
		          		}
		          if (key.equals(Status.FAIL)) {
		          	 	Fail=key.toString();
		          	 	F_Percentage=value.toString();
		          		}
		          }
	        
		    Map<Status, Long> Total_Scripts =Stats.getParent();	 
	        for (Map.Entry<Status, Long> details : Total_Scripts.entrySet()) {
	  	  		Status key = details.getKey();
	  	  		Long value = details.getValue();
	          if (key.equals(Status.PASS)) {
		          	T_Pass=key.toString();
		          	P_Scrips=value.toString();
	          		}
	          if (key.equals(Status.FAIL)) {
		          	T_Fail=key.toString();
		          	F_Scripts=value.toString();
	          		}
	          }
	        
	        List<Test> testList = extent.getReport().getTestList();
	        int totalTestScripts = testList.size();
	        
	         result = "Total Scripts : " + totalTestScripts + "\n"
	                + Pass + " : " + P_Percentage + "%" + "\n"
	                + Fail + " : " + F_Percentage + "%" + "\n"
	                + T_Pass + " Scripts : " + P_Scrips + "\n"
	                + T_Fail + " Scripts : " + F_Scripts+ "\n"
	                +"Executed on browser : " + browserName+ "\n"+"\n"
	                +"Please find the attachment below for the detailed report.";
			}
	  
		
		@AfterClass
		public void Close_Browser() {
			extent.flush();
			
		}
	
		
		@AfterSuite
		public void TearDown() throws EmailException {
			if (driver != null) {
				driver.quit();
			}
			Java_Mail.sendmail();   
			System.out.println("Report generated at: " + userdir + "/Reports/Automation_Report.html");
		}
}
