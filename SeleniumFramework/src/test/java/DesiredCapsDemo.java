import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapsDemo {

	public static void main(String[] args) {
		
		


		WebDriverManager.edgedriver().setup(); 
		WebDriver driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get("https://apple.com");
		
		AppleSearchPage searchPageObj = new AppleSearchPage(driver);
		
		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();
		
		
		driver.quit();
	}

}
