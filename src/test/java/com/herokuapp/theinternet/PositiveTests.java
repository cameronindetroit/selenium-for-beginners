package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {
	
	@Test
	public void logintest() {
		
		System.out.println("Starting login test");
		
		//create driver 
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Sleep for 3 seconds
				sleep(3000);
				
				//Maximize browser window
				driver.manage().window().maximize();
				
		
		//open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("The page is open");
		
		//Sleep for 3 seconds
		sleep(2000);
		
		//Enter user name
		
		//Enter password 
		
		//Click login button
		
		//verifications: 
		
		//URL is /secure 
		
		//successful login message
		
		//Logout button is visible. 
		
		//Close Browser
		driver.quit();
		
		
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
