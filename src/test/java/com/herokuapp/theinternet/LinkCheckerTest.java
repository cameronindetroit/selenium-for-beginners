package com.herokuapp.theinternet;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LinkCheckerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void checkLinks() {

		System.out.println("Starting Link Checker");

		// Create Driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Sleep for 3 seconds
		sleep(3000);

		// Maximize Browser Window
		driver.manage().window().maximize();

		// Open Test page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		System.out.println("Page is open");

		// Sleep for 3 seconds
		sleep(3000);

		// Page validation variables
		WebElement landingPageSuccessMessage = driver
				.findElement(By.xpath("//div[@id='content']/h1[@class='heading']"));
		String landingPageExpectedMessage = "Welcome to the-internet";

		// Validation page is correct page
		correctPage(landingPageSuccessMessage, landingPageExpectedMessage);
		System.out.println("Correct Page has been validated");

		sleep(3000);

		// Validate first Link
		// Click First Link
		WebElement firstLink = driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/abtest']"));
		firstLink.click();

		// Validate correct URL
		WebElement firstLinkPage = driver.findElement(By.xpath("//div[@class='example']"));
		String firstLinkExpectedMessage = "";

		if (firstLinkPage.getText().contains("A/B Test control")) {
			firstLinkExpectedMessage = "A/B Test control";
		} else if (firstLinkPage.getText().contains("A/B Test Variation 1")) {
			firstLinkExpectedMessage = "A/B Test Variation 1";
		}

		// Validate correct verification text
		correctPage(firstLinkPage, firstLinkExpectedMessage);

		System.out.println("First Link has been validated");

		sleep(3000);

		// Navigate back to landing
		driver.get(url);
		System.out.println("Page is open");

		// Validation page is correct page
		WebElement landingPageSuccessMessage2 = driver
				.findElement(By.xpath("//div[@id='content']/h1[@class='heading']"));
		String landingPageExpectedMessage2 = "Welcome to the-internet";
		correctPage(landingPageSuccessMessage2, landingPageExpectedMessage2);
		System.out.println("Correct Page has been validated");
		sleep(3000);

		// Validate Second Link
		WebElement secondLink = driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/add_remove_elements/']"));
		secondLink.click();

		// Validate correct URL
		WebElement secondLinkPage = driver.findElement(By.xpath("//div[@id='content']/h3[.='Add/Remove Elements']"));
		String secondLinkExpectedMessage = "Add/Remove Elements";

		// Validate correct verification text
		correctPage(secondLinkPage, secondLinkExpectedMessage);
		
		sleep(3000);

		System.out.println("Second Link has been validated");

		// Navigate back to landing page

		// Close Browser
		driver.quit();

	}

	// Class methods
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void correctPage(WebElement successMessage, String expectedMessage) {
		String actualMessage = successMessage.getText();
		Assert.assertTrue("Actual Message does not contain expected message", actualMessage.contains(expectedMessage));
	}
}
