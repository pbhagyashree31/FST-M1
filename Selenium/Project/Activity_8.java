package Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Activity_8 {
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
		// Finnding element
		driver.findElement(By.xpath("//li/a[contains(text(),'Contact')]")).click();
		// Assertion for 2nd page title
		Assert.assertEquals(driver.getTitle(), "Contact – Alchemy LMS");

		driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Bhagyashree");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bpanigrahy@in.ibm.com");
		driver.findElement(By.xpath("//input[@type='text' and @id='wpforms-8-field_3']"))
				.sendKeys("unable to open courses");
		driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("trying to open a course");
		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Send Message')]")).click();
		String message = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Thanks for contacting us! We will be in touch with you shortly.");

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
}
