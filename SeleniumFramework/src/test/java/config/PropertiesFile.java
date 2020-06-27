package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import POM_Tests.AppleSearchTest2_testNG_Demo;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String ProjectPath = System.getProperty("user.dir");



	public static void main(String[] args) {


		getProperties();
		setProperties();
	}


	public static void getProperties() {


		try {


			InputStream input = new FileInputStream(ProjectPath +"/src/test/java/config/config.properties");


			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			
			
			AppleSearchTest2_testNG_Demo.browserName = browser;
		

		} 

		catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} 		
	}



	public static void setProperties() {

		try {
			
			OutputStream output = new FileOutputStream(ProjectPath +"/src/test/java/config/config.properties");
		
			prop.setProperty("result", "Pass");
			prop.store(output,null);
		
		} 


		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}




}
