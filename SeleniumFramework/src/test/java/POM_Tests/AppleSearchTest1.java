package POM_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppleSearchTest1 {
	
	
	private static WebDriver driver;
	
	
	public static void main(String[] args) {
		appleSearchTest();
	}
	
	public static void appleSearchTest() {
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		AppleSearchPage searchPageObj = new AppleSearchPage(driver);
		
		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();
		
		//driver.close();
		
	}
	

}
