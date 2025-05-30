package Base_Package;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v136.network.Network;
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
		public static String Skip;
		public static String Skip_Percentage;
			
		public static String T_Pass;
		public static String P_Scrips;
		public static String T_Fail;
		public static String F_Scripts;
		public static String T_Skip;
		public static String Skip_Scripts;
		
  	 	
		public static String result;
		
		public static  	String reportPath ;
		
		  public static final String Received_Document = userdir+"/Files/Received_Document.pdf";
		  public static final String Submitted_Document = userdir+"/Files/Submitted_Document.pdf";
		  public static final String Supported_Document = userdir+"/Files/Supporting_Document.docx";
		  
		@BeforeSuite
		public void generateReport() throws IOException{
			
			String timestamp = new SimpleDateFormat("dd-MM-yy_HH-mm-ss").format(new Date());
			reportPath = "Reports/Automation_Report_" + timestamp + ".html";
			sparkReporter = new ExtentSparkReporter(reportPath);
			sparkReporter.loadXMLConfig(new File(userdir + "/Files/extentconfig.xml"));
			extent = new ExtentReports();
		    extent.attachReporter(sparkReporter);	
		    extent.setSystemInfo("Project_Name", "bidPlan");
		    extent.setSystemInfo("Environment", "QA");
		    
		}
		
		public static DevTools devTools;
		
		@BeforeClass 
		@Parameters({"url"})
		public void setUp(String url) throws IOException{
		    ChromeOptions options = new ChromeOptions();
		    String userDataDir = userdir + "/Chrome user profile/chrome_user_data_" + System.currentTimeMillis();
		    Files.createDirectories(Paths.get(userDataDir));   
			
			options.addArguments("--headless=new");
			options.addArguments("--disable-gpu","--disable-dev-shm-usage","--no-sandbox", "user-data-dir=" + userDataDir); 
			
		    driver = new ChromeDriver(options);
		    browserName = ((ChromeDriver) driver).getCapabilities().getBrowserName();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.manage().window().maximize();
		    
		    devTools = ((ChromeDriver) driver).getDevTools();
		    devTools.createSession();	
		    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
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
		          if (key.equals(Status.SKIP)) {
		          	 	Skip=key.toString();
		          	 	Skip_Percentage=value.toString();
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
	          if (key.equals(Status.SKIP)) {
		          	T_Skip=key.toString();
		          	Skip_Scripts=value.toString();
	          		}
	          }
	        
	        List<Test> testList = extent.getReport().getTestList();
	        int totalTestScripts = testList.size();
	        
	         result = "Total Scripts : " + totalTestScripts + "\n"
	                + Pass + " : " + P_Percentage + "%" + "\n"
	                + Fail + " : " + F_Percentage + "%" + "\n"
	                + Skip + " : " + Skip_Percentage + "%" + "\n"
	                + T_Pass + " Scripts : " + P_Scrips + "\n"
	                + T_Fail + " Scripts : " + F_Scripts+ "\n"
	                + T_Skip + " Scripts : " + Skip_Scripts+ "\n"
	                +"Executed on browser : " + browserName+ "\n"+"\n"
	                +"Please find the attachment below for the detailed report.";
			}
	  
		

		@AfterClass
		public void PushResultToReport() {
			extent.flush();
			if (driver != null) {
				driver.quit();
			}
			
		}
	
		
//		@AfterSuite
		public void TearDown() throws EmailException {
			Java_Mail.sendmail();   
			System.out.println("Report generated at: " + userdir + reportPath);
		}
}
