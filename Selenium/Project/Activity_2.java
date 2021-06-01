package Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Activity_2 {
	// Create a new instance of the Firefox driver
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		driver = new FirefoxDriver();
		// Open browser
		driver.get("https://alchemy.hguy.co/lms/");
	}

	@Test
	public void test1() {
		// Check the title of the page
		String title = driver.getTitle();
		// Print the title of the page
		System.out.println("Page title is: " + title);
		// Assertion for page title
		Assert.assertEquals(title, "Alchemy LMS � An LMS Application");
		WebElement heading=	driver.findElement(By.xpath("//h1[contains(text(),' Learn from Industry Experts')]"));
		
		Assert.assertEquals(heading.getText(), "Learn from Industry Experts");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
}
