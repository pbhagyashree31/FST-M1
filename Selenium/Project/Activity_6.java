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

public class Activity_6 {
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
		Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
		//Finnding element
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		// Assertion for new page title
		Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
		//Finding Login button
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//entering details to login to page
		driver.findElement(By.xpath("//input[@type='text' and @id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@type='password' and @id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Log In']")).click();
		String heading=driver.findElement(By.xpath("//h1[contains(text(),'My Account')]")).getText();
		System.out.println(heading);
		//Assertion to verify the heading present or not
		Assert.assertEquals(heading, "My Account");
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
}
