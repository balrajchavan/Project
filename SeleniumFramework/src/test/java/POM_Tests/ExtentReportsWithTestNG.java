package POM_Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsWithTestNG {
	
	private static WebDriver driver;

	@BeforeMethod
	@BeforeTest
	public void setUp() {
		
		
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void test1() {
		
		AppleSearchPage searchPageObj = new AppleSearchPage(driver);
		
		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();
		
	}
	
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}
}
