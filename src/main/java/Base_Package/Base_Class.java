package Base_Package;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	public static String userdir = System.getProperty("user.dir");
	
	@BeforeSuite
	public void generateReport() throws IOException{
		sparkReporter = new ExtentSparkReporter("Reports/Automation_Report.html");
		sparkReporter.loadXMLConfig(new File(userdir + "/extentconfig.xml"));
		extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);	
	    extent.setSystemInfo("Project_Name", "Test Project");
	    extent.setSystemInfo("Environment", "LOCAL");
	}
	
	@BeforeClass 
	@Parameters({"url"})
	public void setUp(String url) throws IOException{
	    ChromeOptions options = new ChromeOptions();
	    String userDataDir = System.getProperty("user.dir") + "/chrome_user_data_" + System.currentTimeMillis();
	    Files.createDirectories(Paths.get(userDataDir)); // Ensure directory exists
		
		// Additional options required for Linux/Ubuntu environments
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		options.addArguments("user-data-dir=" + userDataDir);
		
		// Setting browser binary path explicitly might be needed on Jenkins
		// options.setBinary("/path/to/chrome-binary"); // Uncomment and set if needed
		
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	      driver.get(url);
	}
		
	@AfterSuite
	public void Close_Browser() {
		extent.flush();
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Report generated at: " + userdir + "/Reports/Automation_Report.html");
	}
}
