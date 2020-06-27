package POM_Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelDataProvider;

//Class to get data from utils -> ExcelDataProvider

public class AppleSearchTest2_testNG {


	
	//dataProvider object initiation for the login test
	ExcelDataProvider dataProvider = new ExcelDataProvider();

	private static WebDriver driver;

	@BeforeTest
	public void setUpTest() {

		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	
	
	
	
	//getting data for the login test with the dataProvider 
	
	@DataProvider(name="loginTestData")
	public Object[][] getData() {
		
		String projectPath= System.getProperty("user.dir");
		
		String excelPath = projectPath+"/excel/data.xlsx" ;

		//dataProvider.testData(excelPath, "Sheet2");
		
		Object data[][]= dataProvider.testData(excelPath, "Sheet1");

		return data;
	}
	
	

	
	
	
	
	@Test
	public void appleSearchTest() {

		AppleSearchPage searchPageObj = new AppleSearchPage(driver);

		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();


	}
	
	
	
	//login test with the data provider
	
	@Test(dataProvider="loginTestData")
	public void appleLoginTest(String userName, String Password) {
		
		
		driver.get("https://secure2.store.apple.com/shop/sign_in?c=aHR0cHM6Ly93d3cuYXBwbGUuY29tL3wxYW9zZTQyMmM4Y2NkMTc4NWJhN2U2ZDI2NWFmYWU3NWI4YTJhZGIyYzAwZQ&r=SCDHYHP7CY4H9XK2H&s=aHR0cHM6Ly93d3cuYXBwbGUuY29tL3wxYW9zZTQyMmM4Y2NkMTc4NWJhN2U2ZDI2NWFmYWU3NWI4YTJhZGIyYzAwZQ");
		
		
		driver.findElement(By.id("loginHome.customerLogin.appleId")).sendKeys(userName);
		driver.findElement(By.id("loginHome.customerLogin.password")).sendKeys(Password);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDownTest() {

		driver.close();
		driver.quit();
		System.out.println("Test completed successfully");

	}


}
