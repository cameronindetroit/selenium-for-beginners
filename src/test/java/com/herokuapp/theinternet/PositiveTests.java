package com.herokuapp.theinternet;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PositiveTests {

	@SuppressWarnings("deprecation")
	@Test
	public void logintest() {

		System.out.println("Starting login test");

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
		username.sendKeys("tomsmith");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		sleep(3000);
		// Click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		sleep(5000);

		// verifications:

		// URL is /secure
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page URL is not the same as expected Url");

		// successful login message
		WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
//		Assert.assertEquals(actualMessage, expectedMessage, "Actual Message does not match expected message");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual Message does not match expected message. \nActual Message: " + actualMessage
						+ "\nExpectedMessage" + expectedMessage);

		// Logout button is visible.
		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not visible.");

		// Close Browser
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
