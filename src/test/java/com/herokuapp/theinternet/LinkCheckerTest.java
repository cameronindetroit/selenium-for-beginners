package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkCheckerTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkLinks () {
		
		System.out.println("Starting Link Checker");
		
		//Create Driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		
		//Sleep for 3 seconds
		sleep(3000);
		
		//Maximize Browser Window
		driver.manage().window().maximize();
		
		
		//Open Test page 
		
		//Sleep for 3 seconds
		
		//Verify page is correct page 
		
		//Select First Link 
		
		//Validate correct URL
		
		//Validate correct verification text 
		
		//Navigate back to landing page
		
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
