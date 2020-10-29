package com.herokuapp.theinternet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NegativeTests {

	@SuppressWarnings("deprecation")
	@Test
	public void incorrectUsernameTest() {

		System.out.println("Starting Incorrect Username test");

		// create driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Sleep for 3 seconds
		sleep(3000);

		// Maximize browser window
		driver.manage().window().maximize();

		// open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("The page is open");

		// Sleep for 3 seconds
		sleep(2000);

		// Enter user name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmithIcorrect");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		sleep(3000);
		// Click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		sleep(5000);

		// Verifications

		WebElement errorMEssage = driver.findElement(By.id("flash"));
		String expectedErrorMessage = "Your username is invalid!";
		String actualErrorMessage = errorMEssage.getText();

		Assert.assertTrue("Actual error message does not contain expected",
				actualErrorMessage.contains(expectedErrorMessage));

		// Close Broser
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
