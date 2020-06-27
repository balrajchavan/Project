package POM_Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM_Pages.AppleSearchPage;
import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;


//Class to get data from config -> PropertiesFile

public class AppleSearchTest2_testNG_Demo {
	

	
	private static WebDriver driver;
	public static String browserName = null;
	
	
	@BeforeTest
	public void setUpTest() {
		
		
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public static void appleSearchTest() {
		
		AppleSearchPage searchPageObj = new AppleSearchPage(driver);
		
		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();
		
		
	}
	
	
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		//driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();

	}
	

}
