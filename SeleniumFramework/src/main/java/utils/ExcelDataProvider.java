package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.testng.annotations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {

	private static WebDriver driver;


	@Test(dataProvider="test1Data")
	public void test1(String userName, String Password) {

		System.out.println(userName+" | " +Password);

		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();

		driver.get("https://apple.com");
		driver.quit();

	}



	// DataProvider to get username/password 

	@DataProvider(name="test1Data")
	public Object[][] getData() {


		String projectPath= System.getProperty("user.dir");
		
		String excelPath = projectPath+"/excel/data.xlsx";

		Object data[][]= testData(excelPath, "Sheet1");

		return data;

	}


	// Function to get username/password 


	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][]	= new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount ; i++) {

			for(int j=0; j<colCount ; j++) {

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");


				data[i-1][j] = cellData;

			}
			System.out.println();
		}


		return data;

	}









	// for LoginTest_testNG2_dataProvider


	@Test(dataProvider="test2Data")
	public void test2(String browserName) {


		System.out.println(browserName);



		if (browserName.equalsIgnoreCase("chrome")) {


			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")) {


			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		}




		driver.get("https://apple.com");
		driver.quit();

	}





	// DataProvider to get browser 

	@DataProvider(name="test2Data")
	public Object[] getData1() {


		String excelPath = "/Users/chavab01/Desktop/Workplace/SeleniumFramework/excel/data.xlsx";

		Object data[]= testData1(excelPath, "Sheet3");

		return data;

	}


	// Function to get browser name

	public Object[] testData1(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		//int colCount = excel.getColCount();

		Object data[]= new Object[rowCount-1];



		for(int i=1; i<rowCount ; i++) {

			String cellData = excel.getCellDataString(i-1, 0);
			System.out.print(cellData+" | ");
			data[i-1] = cellData;

		}
		System.out.println();



		return data;

	}





}
