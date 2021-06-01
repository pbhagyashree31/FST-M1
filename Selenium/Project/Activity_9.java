package Activities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Activity_9 {
	// Create a new instance of the Firefox driver
	WebDriver driver;
	

	@BeforeMethod
	public void beforeMethod() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		// Finnding element
		driver.findElement(By.xpath("//li/a[contains(text(),'All Courses')]")).click();
		// Assertion for 2nd page title
		Assert.assertEquals(driver.getTitle(), "All Courses – Alchemy LMS");
		
		
		driver.findElement(By.xpath("(//p[@class='ld_course_grid_button']//a)[3]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Expand All')]")).click();
		driver.findElement(By.xpath("//div[@id='ld-table-list-item-24183']/a/div")).click();
		String titleofCourse=driver.findElement(By.xpath("//h1[contains(text(),'The Power Of Effective Content')]")).getText();
		System.out.println(titleofCourse);
		WebElement web=driver.findElement(By.xpath("//div[@id='learndash_post_24183']/div/div[3]/div[2]/form/input[4]"));
		boolean bol=web.isDisplayed();
	
		if(bol=true) {
				web.click();
		}
		else {
			System.out.println("Element is not present");
		}
		
	
	

	}

	
	@AfterMethod
	public void afterMethod() {
		driver.close();

	}
}
