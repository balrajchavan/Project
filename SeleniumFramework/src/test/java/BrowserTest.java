import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup(); 
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.in");
		
		
		driver.quit();
		
	}

}
