package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppleSearchPage {

	WebDriver driver = null;
	
	By textBox_search = By.id("ac-gn-link-search");	
	By textBox_search_input = By.id("ac-gn-searchform-input");	
	By enter_button = By.id("ac-gn-searchform-submit");
	
	
	public AppleSearchPage(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void enterSearchBox() {
		
		driver.findElement(textBox_search).click();
		
		
	}
	
	public void inputSearch(String text) {
		
		driver.findElement(textBox_search_input).sendKeys(text);
	}
	
	
	public void searchEnter() {
		
		driver.findElement(enter_button).click();
	}
}
