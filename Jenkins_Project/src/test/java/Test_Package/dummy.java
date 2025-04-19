package Test_Package;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dummy {
	
	@Test
	public static void abcd( ) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.khanacademy.org/computing/computer-programming");
		
//		aa log = new aa (driver);
//		log.Link();
//		log.UN();
//		log.PWD();
//		log.SUB();
//		
//		bb log1 = new bb(driver);
//		log1.TAB1();
//		log1.NEWprogram();
//		driver.close();
//		
//		
//		cc log2 = new cc(driver);
//		log2.TAB2();
//		Thread.sleep(2000);
//		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.navigate().back();
//		//driver.close();
//		
//		
//		dd log3 = new dd(driver);
//		log3.TAB3();
//		
	}

}
